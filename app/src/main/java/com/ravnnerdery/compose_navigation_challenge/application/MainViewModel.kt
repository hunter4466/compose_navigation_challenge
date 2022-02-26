package com.ravnnerdery.compose_navigation_challenge.application

import androidx.lifecycle.ViewModel
import com.ravnnerdery.data.useCases.ProvideElementsAreLoadingFlowUseCase
import com.ravnnerdery.data.useCases.ProvideFetchArticleListFlowUseCase
import com.ravnnerdery.data.useCases.ProvideSectionListUseCase
import com.ravnnerdery.data.useCases.ProvideTagsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    provideSectionListUseCase: ProvideSectionListUseCase,
    provideTagsListUseCase: ProvideTagsListUseCase,
    provideFetchArticleListFlowUseCase: ProvideFetchArticleListFlowUseCase,
    provideElementsAreLoadingFlowUseCase: ProvideElementsAreLoadingFlowUseCase
) : ViewModel() {

    val sectionsList = provideSectionListUseCase.execute()
    val tagsList = provideTagsListUseCase.execute()
    val articlesListFlow = provideFetchArticleListFlowUseCase.execute()
    val elementsAreLoadingFlow = provideElementsAreLoadingFlowUseCase.execute()

}