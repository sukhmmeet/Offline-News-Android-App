package com.dhaliwal.offlinenewsapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Article::class],
    version = 2
)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun getArticlesDao() : ArticlesDao
}