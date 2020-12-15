package com.example.viewsapp.remote

import com.example.viewsapp.remote.Pojo.ResponseNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    // http://newsapi.org/v2/top-headlines?country=us&apiKey=e1dea7d74b4a47389b6f8bdb34a688a2
    @GET("/v2/top_headlines")
    suspend fun topHeadlines (
        @Query("country") country: String
    ) : retrofit2.Response<ResponseNews>
}
