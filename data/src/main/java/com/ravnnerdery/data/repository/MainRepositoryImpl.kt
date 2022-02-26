package com.ravnnerdery.data.repository

import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.networking.ArticlesApiService
import com.ravnnerdery.domain.models.Article
import com.ravnnerdery.domain.models.Section
import com.ravnnerdery.domain.models.Tag
import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MainRepositoryImpl @Inject constructor(
    private val databaseDao: DatabaseDao,
    private val apiService: ArticlesApiService,
) : MainRepository {
    private val tagsList = listOf(
        Tag("Cindy Sherman", "artanddesign/cindy-sherman"),
        Tag("John Stezaker", "artanddesign/john-stezaker"),
        Tag("Conrad Shawcross", "artanddesign/conrad-shawcross"),
        Tag("Asterix", "books/asterix"),
        Tag("Beano", "books/beano")
    )
    private val sectionsList = listOf(
        Section("Art & Design", "artanddesign"),
        Section("Books", "books")
    )
    var elementsAreLoading = MutableStateFlow(false)
    override fun provideLoadingState(): Flow<Boolean> = elementsAreLoading
    override fun provideTagsList(): List<Tag> = tagsList
    override fun provideSectionsList(): List<Section> = sectionsList
    override fun fetchArticleListFlow(): Flow<List<Article>> = flow {
        elementsAreLoading.value = true
        tagsList.forEach { tag ->
            sectionsList.forEach { section ->
                val articlesFromApi =
                    apiService.fetchArticles(tag = tag.codeName, section = section.codeName)
                articlesFromApi.response.results.forEach { article ->
                    databaseDao.insertArticle(article.mapToDataBaseModel())
                }
            }
        }
        val articlesTempList = mutableListOf<Article>()
        databaseDao.getAllArticles().forEach { article ->
            articlesTempList.add(article.mapToDomainModel())
        }
        emit(articlesTempList)
        elementsAreLoading.value = false
    }.flowOn(Dispatchers.IO)
}

