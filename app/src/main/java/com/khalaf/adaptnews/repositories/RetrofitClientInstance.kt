package com.khalaf.adaptnews.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://newsapi.org/v2/top-headlines?country=us&apiKey=6785944792ad4970a6bd8ada7c17b98c

object RetrofitClientInstance {
    private var retrofit : Retrofit? = null
    private val BASE_URL = "https://newsapi.org/v2/"

    val retrofitInstance: Retrofit?
        get(){
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()).
                                build()
            }

            return retrofit
        }
}