package com.dhaliwal.offlinenewsapp

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dhaliwal.offlinenewsapp.API_Files.API_Instance
import com.dhaliwal.offlinenewsapp.API_Files.toEntity
import kotlinx.coroutines.flow.Flow

class NewsRepository(
    private val api: API_Instance,
    private val dao: ArticlesDao
) {

    fun getNews(): Flow<List<Article>> {
        return dao.getAllData()
    }

    fun getPagedNews(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10
            ),
            pagingSourceFactory = { dao.getArticlesPaging() }
        ).flow
    }


    suspend fun refreshNews() {
        try {
            val response = api.apiInterface.getData()

            if (response.isSuccessful) {
                val articles = response.body()?.articles ?: emptyList()
                val entityList = articles.map { it.toEntity() }
                dao.upsertAll(entityList)
            }
        } catch (e: Exception) {
            Log.d("Error", "Error in repository refreshNews function")
        }
    }
}
