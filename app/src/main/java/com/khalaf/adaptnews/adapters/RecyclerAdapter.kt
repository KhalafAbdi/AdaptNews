package com.khalaf.adaptnews.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.khalaf.adaptnews.models.ArticleModel
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.khalaf.adaptnews.R
import com.khalaf.adaptnews.WebViewActivity


class RecyclerAdapter(var context :Context, var articles : List<ArticleModel>?) : RecyclerView.Adapter<RecyclerAdapter.ArticelViewHolder>() {
    override fun onBindViewHolder(articelViewHolder: ArticelViewHolder, position: Int) {
        articelViewHolder.bindModel(articles!![position])

        articelViewHolder.itemView.setOnClickListener {

            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("article_url", articles!![position].url)
            context.startActivity(intent)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ArticelViewHolder{
        return ArticelViewHolder(LayoutInflater.from(context).inflate(R.layout.article_item_layout, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return articles!!.size
    }

    fun addArticlesData(data: List<ArticleModel>?) {
        articles = data
        notifyDataSetChanged()
    }

    inner class ArticelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sourceText : TextView = itemView.findViewById(R.id.articleSource)
        val titleText : TextView = itemView.findViewById(R.id.articleTitle)
        val discriptionText : TextView = itemView.findViewById(R.id.articleDescription)
        val imgView : ImageView = itemView.findViewById(R.id.articleImage)


        fun bindModel(article: ArticleModel) {

            sourceText.text = article.source
            titleText.text = article.title
            discriptionText.text = article.discription
            var defultRequest : RequestOptions = RequestOptions().error(R.drawable.ic_launcher_background)

            Glide.with(context)
                    .setDefaultRequestOptions(defultRequest)
                    .load(article.imgURL)
                    .into(imgView)
        }
    }
}