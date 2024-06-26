package com.example.blogc.retrofit_api

import com.example.blogc.model.User
import com.example.blogc.retrofit_api.modelapi.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // 192.168.1.254:9000
    //192.168.50.253:9000
    private const val BASE_URL = "http://192.168.50.253:9000"

    private val userApi: UserApi by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(UserApi::class.java)
    }

    suspend fun saveUser( user: User) { userApi.saveUser(user) }

    suspend fun getAllUsers(): List<User> {
        return userApi.getAllUsers()}
    suspend fun getUserById(userId: Int): User {
        return userApi.getUserById(userId)
    }


    // TODO add suspend functions for saveBlog, getBlogById




}