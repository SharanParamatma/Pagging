package com.india.innovative.helperClass

import com.india.innovative.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
            const val Base_URl = "https://gorest.co.in/public-api/"
    }
    @GET("users")
    suspend fun getUsersData(@Query("page") page: Int): Response<UserResponse>
}