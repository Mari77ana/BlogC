package com.example.blogc.retrofit.modelapi

import com.example.blogc.model.User
import retrofit2.http.GET

interface UserApi {

    @GET("/user/get-all")
    suspend fun getAllUsers(): List<User>

}