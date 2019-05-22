package com.khalaf.adaptnews.repositories.data

data class CurrentNewsApiResponse(
        val status: String,
        val totalResults: Int,
        val articles: List<Article>
)