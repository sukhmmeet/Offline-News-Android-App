package com.dhaliwal.offlinenewsapp.API_Files

import com.dhaliwal.offlinenewsapp.API_Files.response.Article

fun Article.toEntity(): com.dhaliwal.offlinenewsapp.Article {
    return com.dhaliwal.offlinenewsapp.Article(
        id = id,
        content = content ?: "",
        description = description ?: "",
        image = image ?: "",
        lang = lang ?: "",
        publishedAt = publishedAt ?: "",
        sourceName = source.name ?: "",
        title = title ?: "",
        url = url ?: ""
    )
}
