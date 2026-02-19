package com.dhaliwal.offlinenewsapp.API_Files.response

data class responseData(
    val articles: List<Article>,
    val information: Information,
    val totalArticles: Int
)