package com.ravnnerdery.data.networking.models

data class ApiArticleResponseResultTags(
    val id: String,
    val type: String,
    val sectionName: String = "Unknown",
    val webTitle: String,
)