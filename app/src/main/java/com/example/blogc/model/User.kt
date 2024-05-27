package com.example.blogc.model

data class User(
    val id: Int?, // testar
    val name: String,
    val lastname: String,
    val email: String,
    val password: String,
    val comment: String,

    // TODO add val blogList: List<Blog> here
)
