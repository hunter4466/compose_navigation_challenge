package com.ravnnerdery.compose_navigation_challenge.application

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ravnnerdery.data.useCases.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel(
            ProvideSectionListUseCaseTest(),
            ProvideTagsListUseCaseTest(),
            ProvideFetchArticleListFlowUseCaseTest(),
            ProvideElementsAreLoadingFlowUseCaseTest()
        )
    }

    @Test
    fun getSectionsList() {
        val response = viewModel.sectionsList
        assertEquals("Section 1 Name", response[0].name)
    }

    @Test
    fun getTagsList() {
        val response = viewModel.tagsList
        assertEquals("Tag 1 Name", response[0].name)
    }

    @Test
    fun getArticlesList() = runBlocking {
        viewModel.articlesListFlow.collect {
            assertEquals("article_id_1", it[0].articleId)
        }
    }

    @Test
    fun getElementsAreLoadingFlow() = runBlocking {
        viewModel.elementsAreLoadingFlow.collect {
            assertEquals(true, it)
        }
    }
}