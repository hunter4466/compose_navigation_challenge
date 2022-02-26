package com.ravnnerdery.data.networking.models

import com.ravnnerdery.data.database.models.ArticleEntity
import com.ravnnerdery.domain.mappers.DataBaseMapper

class ApiArticleResponseResult(
    private val id: String,
    private val sectionId: String,
    private val sectionName: String,
    private val fields: ApiArticleResponseResultFields,
    private val tags: List<ApiArticleResponseResultTags>
) : DataBaseMapper<ArticleEntity> {
    override fun mapToDataBaseModel(): ArticleEntity {
        val stringedTags = mutableListOf<String>()
        tags.forEach {
            stringedTags.add(it.id)
        }
        return ArticleEntity(
            articleId = id,
            sectionId = sectionId,
            sectionName = sectionName,
            headline = fields.headline,
            trailText = fields.trailText,
            body = fields.body,
            shortUrl = fields.shortUrl,
            thumbnail = fields.thumbnail,
            tagsList = stringedTags.joinToString(separator = ",")
        )
    }
}