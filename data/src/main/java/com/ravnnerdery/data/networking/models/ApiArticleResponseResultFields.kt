package com.ravnnerdery.data.networking.models

data class ApiArticleResponseResultFields (
    val headline: String,
    val trailText: String,
    val body: String,
    val shortUrl: String,
    val thumbnail: String = "Unknown",
)