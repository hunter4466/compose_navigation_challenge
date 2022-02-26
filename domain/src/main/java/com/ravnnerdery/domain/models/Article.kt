package com.ravnnerdery.domain.models

data class Article(
    val id: Long,
    val articleId: String,
    val sectionId: String,
    val sectionName: String,
    val headline: String,
    val trailText: String,
    val body: String,
    val shortUrl: String,
    val thumbnail: String,
    val tagsList: List<String>,
)
