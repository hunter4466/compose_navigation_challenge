package com.ravnnerdery.data.useCases

import com.ravnnerdery.domain.models.Article
import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface ProvideFetchArticleListFlowUseCase {
    fun execute(): Flow<List<Article>>
}

class ProvideFetchArticleListFlowUseCaseImpl @Inject constructor(private val repo: MainRepository) :
    ProvideFetchArticleListFlowUseCase {
    override fun execute(): Flow<List<Article>> = repo.fetchArticleListFlow()
}

class ProvideFetchArticleListFlowUseCaseTest : ProvideFetchArticleListFlowUseCase {
    override fun execute(): Flow<List<Article>> = flow {
        emit(
            listOf(
                Article(
                    1,
                    "article_id_1",
                    "section_id_1",
                    "sectionName_1",
                    "headline_1",
                    "trailText_1",
                    "body_1",
                    "shortUrl_1",
                    "thumbnail_1",
                    listOf("tag_1", "tag_2")
                ),
                Article(
                    2,
                    "article_id_2",
                    "section_id_2",
                    "sectionName_2",
                    "headline_2",
                    "trailText_2",
                    "body_2",
                    "shortUrl_2",
                    "thumbnail_2",
                    listOf("tag_3", "tag_4")
                ),
                Article(
                    3,
                    "article_id_3",
                    "section_id_3",
                    "sectionName_3",
                    "headline_3",
                    "trailText_3",
                    "body_3",
                    "shortUrl_3",
                    "thumbnail_3",
                    listOf("tag_5", "tag_6")
                ),
            )
        )
    }
}