package com.khalaf.adaptnews.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

import com.khalaf.adaptnews.models.ArticleModel
import com.khalaf.adaptnews.repositories.ArticleRepository

class ArticleViewModel : ViewModel() {
    var articles :  MutableLiveData<List<ArticleModel>> = ArticleRepository.getArticles()

    fun getArticles() : LiveData<List<ArticleModel>>{
        return articles
    }

}