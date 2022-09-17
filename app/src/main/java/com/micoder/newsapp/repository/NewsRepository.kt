package com.micoder.newsapp.repository

import com.micoder.newsapp.api.RetrofitInstance
import com.micoder.newsapp.db.ArticleDatabase

class NewsRepository(val db : ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber : Int) = RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

}