package com.dhaliwal.offlinenewsapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey
    val id : String,
    val content : String,
    val description : String,
    val image : String,
    val lang : String,
    val publishedAt : String,
    val sourceName : String,
    val title : String,
    val url : String
)
