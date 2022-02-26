package com.ravnnerdery.domain.repository

import com.ravnnerdery.domain.models.Article
import com.ravnnerdery.domain.models.Section
import com.ravnnerdery.domain.models.Tag
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun provideSectionsList(): List<Section>
    fun provideTagsList(): List<Tag>
    fun fetchArticleListFlow(): Flow<List<Article>>
    fun provideLoadingState(): Flow<Boolean>
}