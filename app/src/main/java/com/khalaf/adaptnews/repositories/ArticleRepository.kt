package com.khalaf.adaptnews.repositories

import android.arch.lifecycle.MutableLiveData
import com.khalaf.adaptnews.models.ArticleModel
import com.khalaf.adaptnews.repositories.data.Article
import com.khalaf.adaptnews.repositories.data.CurrentNewsApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ArticleRepository {
    var dataset : ArrayList<ArticleModel> = ArrayList()

    fun getArticles() : MutableLiveData<List<ArticleModel>> {

        var data : MutableLiveData<List<ArticleModel>> = MutableLiveData()
        setData(data)

        data.postValue(dataset)
        return data
    }


    private fun setData(data : MutableLiveData<List<ArticleModel>>){
        val service = RetrofitClientInstance.retrofitInstance?.create(ArticleApiService::class.java)
        val call = service?.getCurrentTopHeadlines("techcrunch")

        call?.enqueue(object : Callback<CurrentNewsApiResponse> {
            override fun onFailure(call: Call<CurrentNewsApiResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<CurrentNewsApiResponse>?, response: Response<CurrentNewsApiResponse>?) {
                val body = response?.body()

                for (article : Article in body!!.articles){
                    dataset.add(ArticleModel(article.source.name, article.title,article.description,article.url, article.urlToImage))
                }

                data.value = dataset
            }
        })
    }
}