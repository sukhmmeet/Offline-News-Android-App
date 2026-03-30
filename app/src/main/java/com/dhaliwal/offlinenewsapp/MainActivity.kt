package com.dhaliwal.offlinenewsapp

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.room.Room
import com.dhaliwal.offlinenewsapp.API_Files.API_Instance
import com.dhaliwal.offlinenewsapp.ui.theme.OfflineNewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            OfflineNewsAppTheme {

                val context = LocalContext.current

                val db = Room.databaseBuilder(
                    context,
                    ArticleDatabase::class.java,
                    "articles.db"
                ).build()

                val repository = NewsRepository(
                    api = API_Instance,
                    dao = db.getArticlesDao()
                )

                val factory = NewsViewModelFactory(repository)
                val viewModel: NewsViewModel = viewModel(factory = factory)

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            if (!isSystemInDarkTheme()) Color.Black else Color.White
                        )
                ) {
                    NewsUI(
                        reload = { viewModel.refreshNews() },
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsUI(
    reload: () -> Unit,
    viewModel: NewsViewModel
) {
    val articles = viewModel.pagedNews.collectAsLazyPagingItems()
    val pullToRefreshState = rememberPullToRefreshState()

    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "News",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(15.dp)
            )
        }

        PullToRefreshBox(
            isRefreshing = articles.loadState.refresh is LoadState.Loading,
            onRefresh = {
                reload()
            },
            state = pullToRefreshState,
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                when (articles.loadState.refresh) {

                    is LoadState.Loading -> {
                        item {
                            Box(
                                modifier = Modifier.fillParentMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    }

                    is LoadState.Error -> {
                        item {
                            Text("Error loading data")
                        }
                    }

                    else -> {
                        items(articles.itemCount) { index ->
                            articles[index]?.let {
                                NewsItem(it)
                            }
                        }
                    }
                }
            }
        }
    }
}
