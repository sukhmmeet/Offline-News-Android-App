package com.dhaliwal.offlinenewsapp

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticlesDao {
    @Query("SELECT * FROM articles ORDER BY RANDOM()")
    fun getAllData() : Flow<List<Article>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(data: List<Article>)
    @Query("SELECT * FROM articles ORDER BY publishedAt DESC")
    fun getArticlesPaging(): PagingSource<Int, Article>


}