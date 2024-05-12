package com.example.blogc.retrofit.modelapi

import com.example.blogc.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {

    @GET("/users/get-all")
    suspend fun getAllUsers(): List<User>

    @POST("/users/save")
    suspend fun saveUser(@Body user: User): User

    @GET("/users/{userId}")
    suspend fun getUserById(@Path("userId") userId: Int): User

}