package com.dhaliwal.offlinenewsapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun NewsItem(article: Article) {

    var showDialog = androidx.compose.runtime.remember {
        androidx.compose.runtime.mutableStateOf(false)
    }

    Surface (
        onClick = { showDialog.value = true },
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = article.title,
                        maxLines = 2,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(5.dp)
                    )
                    Text(
                        text = article.title,
                        maxLines = 2,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(5.dp)
                    )
                }

                AsyncImage(
                    model = article.image,
                    contentDescription = "article_image",
                    modifier = Modifier.size(70.dp),
                    contentScale = ContentScale.Crop
                )

            }
        }
        HorizontalDivider()
        }

    if (showDialog.value) {
        ArticleDialog(
            article = article,
            onDismiss = { showDialog.value = false }
        )
    }
}


@Composable
@Preview
fun Preview(){
    NewsItem(
        Article(
            "id",
            "content",
            "description",
            "imageUrl",
            "en",
            "121251123HHHH",
            "Gawandi aunty",
            "title",
            "Url link"
        )
    )
}