package com.khalaf.adaptnews.repositories

import com.khalaf.adaptnews.repositories.data.CurrentNewsApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

const val API_KEY = "6785944792ad4970a6bd8ada7c17b98c"

/*
Top-Headlines
https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=6785944792ad4970a6bd8ada7c17b98c"
https://newsapi.org/v2/top-headlines?country=us&apiKey=6785944792ad4970a6bd8ada7c17b98c

 */

/*
Everything
https://newsapi.org/v2/everything?q=bitcoin&apiKey=6785944792ad4970a6bd8ada7c17b98c
https://newsapi.org/v2/everything?q=apple&from=2019-04-03&to=2019-04-03&sortBy=popularity&apiKey=6785944792ad4970a6bd8ada7c17b98c
https://newsapi.org/v2/everything?q=apple&from=2019-04-03&to=2019-04-03&sortBy=popularity&apiKey=6785944792ad4970a6bd8ada7c17b98c
 */

/*
Sources
https://newsapi.org/v2/sources?apiKey=6785944792ad4970a6bd8ada7c17b98c
https://newsapi.org/v2/sources?language=en&apiKey=6785944792ad4970a6bd8ada7c17b98c
https://newsapi.org/v2/sources?language=en&country=us&apiKey=6785944792ad4970a6bd8ada7c17b98c

 */

interface ArticleApiService {

    @GET(value = "top-headlines")
    fun getCurrentTopHeadlines(
            @Query(value = "sources") source: String,
            @Query("apiKey") apiKey: String = API_KEY
    ): Call<CurrentNewsApiResponse>


    @GET(value = "everything")
    fun getEverything(
            @Query(value = "q") word: String,
            @Query(value = "from") from: Date,
            @Query(value = "to") to: Date,
            @Query(value = "sortBy") popularity: String,
            @Query("apiKey") apiKey: String = API_KEY
    ): Call<CurrentNewsApiResponse>

    @GET(value = "sources")
    fun getSources(
            @Query(value = "language") language: String,
            @Query(value = "country") country: String,
            @Query("apiKey") apiKey: String = API_KEY
    ): Call<CurrentNewsApiResponse>

}

