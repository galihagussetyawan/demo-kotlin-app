package com.example.app.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getInstance(): Retrofit {

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit as Retrofit
    }
}