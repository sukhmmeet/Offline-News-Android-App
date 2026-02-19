package com.dhaliwal.offlinenewsapp


import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import androidx.core.net.toUri

@Composable
fun ArticleDialog(
    article: Article,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        },
        title = {
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleLarge
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {

                // 🖼 Image
                AsyncImage(
                    model = article.image,
                    contentDescription = "article_image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Source: ${article.sourceName}",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = "Published: ${article.publishedAt}",
                    style = MaterialTheme.typography.labelSmall
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = article.description,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = article.content,
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Language: ${article.lang}",
                    style = MaterialTheme.typography.labelSmall
                )

                val context = LocalContext.current

                Text(
                    text = article.url,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, article.url.toUri())
                        context.startActivity(intent)
                    }
                )

            }
        }
    )
}


@Composable
@Preview
private fun Preview1(){
    ArticleDialog (
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
        ), {}
    )
}