package com.dhaliwal.offlinenewsapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.launch


class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    val pagedNews = repository
        .getPagedNews()
        .cachedIn(viewModelScope)

    fun refreshNews() {
        viewModelScope.launch {
            try {
                repository.refreshNews()
            } catch (e: Exception) {
                Log.d("error", e.toString())
            }
        }
    }
}

