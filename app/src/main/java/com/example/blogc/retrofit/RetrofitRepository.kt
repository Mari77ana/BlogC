package com.example.blogc.retrofit

import com.example.blogc.model.User
import com.example.blogc.retrofit.modelapi.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "http://192.168.1.254:9000"

    private val userApi: UserApi by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(UserApi::class.java)
    }

    suspend fun saveUser( user: User) { userApi.saveUser(user) }

    suspend fun getAllUsers() { userApi.getAllUsers()}

}