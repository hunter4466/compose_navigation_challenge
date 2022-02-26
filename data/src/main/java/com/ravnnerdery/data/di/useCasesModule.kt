package com.ravnnerdery.data.di

import com.ravnnerdery.data.useCases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    @Singleton
    fun provideSectionsListUseCase(
        provideSectionListUseCaseImpl: ProvideSectionListUseCaseImpl
    ): ProvideSectionListUseCase {
        return provideSectionListUseCaseImpl
    }

    @Provides
    @Singleton
    fun provideTagsListUseCase(
        provideTagsListUseCaseImpl: ProvideTagsListUseCaseImpl
    ): ProvideTagsListUseCase {
        return provideTagsListUseCaseImpl
    }

    @Provides
    @Singleton
    fun provideFetchListUseCase(
        provideFetchArticleListFlowUseCaseImpl: ProvideFetchArticleListFlowUseCaseImpl
    ): ProvideFetchArticleListFlowUseCase {
        return provideFetchArticleListFlowUseCaseImpl
    }

    @Provides
    @Singleton
    fun provideElementsAreLoadingFlowUseCase(
        provideElementsAreLoadingFlowUseCaseImpl: ProvideElementsAreLoadingFlowUseCaseImpl
    ): ProvideElementsAreLoadingFlowUseCase {
        return provideElementsAreLoadingFlowUseCaseImpl
    }
}