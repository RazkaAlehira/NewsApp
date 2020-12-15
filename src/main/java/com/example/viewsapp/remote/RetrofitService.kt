package com.example.viewsapp.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val client = OkHttpClient.Builder().addInterceptor(RequestInterceptor()).build()

    private fun interceptor() : Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}

private fun OkHttpClient.Builder.addInterceptor(requestInterceptor: RequestInterceptor): Any {
    TODO("Not yet implemented")
}

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()

        requestBuilder.addHeader("Authorization", "e1dea7d74b4a47389b6f8bdb34a688a2")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}