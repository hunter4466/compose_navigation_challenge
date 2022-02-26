package com.ravnnerdery.data.useCases

import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface ProvideElementsAreLoadingFlowUseCase {
    fun execute(): Flow<Boolean>
}

class ProvideElementsAreLoadingFlowUseCaseImpl @Inject constructor(private val repo: MainRepository) :
    ProvideElementsAreLoadingFlowUseCase {
    override fun execute(): Flow<Boolean> = repo.provideLoadingState()
}

class ProvideElementsAreLoadingFlowUseCaseTest : ProvideElementsAreLoadingFlowUseCase {
    override fun execute(): Flow<Boolean> = flow { emit(true) }
}