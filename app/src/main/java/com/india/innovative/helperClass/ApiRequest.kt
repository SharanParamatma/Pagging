package com.india.innovative.helperClass

import com.india.innovative.helperClass.ApiService.Companion.Base_URl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiRequest {

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val timeUnit = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(logger)
            .build()

    fun getClient() : ApiService {
        return Retrofit.Builder()
                .baseUrl(Base_URl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(timeUnit)
                .build()
                .create(ApiService::class.java)
    }

}