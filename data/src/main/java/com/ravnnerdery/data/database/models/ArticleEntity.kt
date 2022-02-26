package com.ravnnerdery.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ravnnerdery.data.mappers.DomainMapper
import com.ravnnerdery.domain.models.Article

@Entity(tableName = "articles_table", indices = [Index(value = ["articleId"], unique = true)])
class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "articleId")
    val articleId: String,
    @ColumnInfo
    val sectionId: String,
    @ColumnInfo
    val sectionName: String,
    @ColumnInfo
    val headline: String,
    @ColumnInfo
    val trailText: String,
    @ColumnInfo
    val body: String,
    @ColumnInfo
    val shortUrl: String,
    @ColumnInfo
    val thumbnail: String,
    @ColumnInfo
    val tagsList: String,
) : DomainMapper<Article> {
    override fun mapToDomainModel(): Article = Article(
        id,
        articleId,
        sectionId,
        sectionName,
        headline,
        trailText,
        body,
        shortUrl,
        thumbnail,
        tagsList.split(",")
    )
}