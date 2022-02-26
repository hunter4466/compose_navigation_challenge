package com.ravnnerdery.data.networking

import com.ravnnerdery.data.networking.models.ApiArticleBundle
import retrofit2.http.GET
import retrofit2.http.Query


interface ArticlesApiService {

    @GET("search")
    suspend fun fetchArticles(
        @Query("tag") tag: String,
        @Query("section") section: String,
        @Query("show-fields") showFields: String = "trailText,headline,body,thumbnail,shortUrl",
        @Query("show-tags") showTags: String = "all"
    ): ApiArticleBundle

}
