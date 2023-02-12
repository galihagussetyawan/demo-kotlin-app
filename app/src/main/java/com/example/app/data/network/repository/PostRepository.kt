package com.example.app.data.network.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.app.data.network.Retrofit
import com.example.app.data.network.service.PostService
import com.example.app.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {

    private var postService: PostService? = null

    init {
        postService = Retrofit().getInstance().create(PostService::class.java)
    }

    fun fetchAllPosts(): LiveData<List<Post>> {
        val data = MutableLiveData<List<Post>>()

        postService?.fetchAllPosts()?.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                data.postValue(response?.body())
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return data
    }
}