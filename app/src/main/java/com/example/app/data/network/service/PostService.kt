package com.example.app.data.network.service

import com.example.app.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun fetchAllPosts(): Call<List<Post>>
}