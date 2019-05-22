package com.khalaf.adaptnews

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import com.khalaf.adaptnews.adapters.RecyclerAdapter
import com.khalaf.adaptnews.viewmodels.ArticleViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var articleViewModel : ArticleViewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
        articleViewModel.articles


        var recyclerAdapter  = RecyclerAdapter(this, articleViewModel.getArticles().value)


        articleViewModel.articles.observe(this, Observer {

            recyclerAdapter.addArticlesData(it)
        })

        list_of_articles.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        list_of_articles.adapter = recyclerAdapter


}


}
