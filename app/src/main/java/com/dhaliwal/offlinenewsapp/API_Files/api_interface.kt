package com.dhaliwal.offlinenewsapp.API_Files


import com.dhaliwal.offlinenewsapp.API_Files.response.responseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface api_interface {
    @GET("top-headlines")
    suspend fun getData(
        @Query("category") category : String = "general",
        @Query("lang") lang : String = "en",
        @Query("apikey") key : String = "Use your key"
    ) : Response<responseData>
}
