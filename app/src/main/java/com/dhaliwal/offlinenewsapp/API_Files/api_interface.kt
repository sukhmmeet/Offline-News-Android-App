package com.dhaliwal.offlinenewsapp.API_Files


import com.dhaliwal.offlinenewsapp.API_Files.response.responseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// https://gnews.io/api/v4/top-headlines?category=general&lang=en&apikey=dde4bd86f3c0ca2960687db96364f0ff
interface api_interface {
    @GET("top-headlines")
    suspend fun getData(
        @Query("category") category : String = "general",
        @Query("lang") lang : String = "en",
        @Query("apikey") key : String = "dde4bd86f3c0ca2960687db96364f0ff"
    ) : Response<responseData>
}