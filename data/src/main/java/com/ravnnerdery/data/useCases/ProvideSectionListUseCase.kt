package com.ravnnerdery.data.useCases

import com.ravnnerdery.domain.models.Section
import com.ravnnerdery.domain.repository.MainRepository
import javax.inject.Inject

interface ProvideSectionListUseCase {
    fun execute(): List<Section>
}

class ProvideSectionListUseCaseImpl @Inject constructor(private val repo: MainRepository) :
    ProvideSectionListUseCase {
    override fun execute(): List<Section> {
        return repo.provideSectionsList()
    }
}

class ProvideSectionListUseCaseTest : ProvideSectionListUseCase {
    override fun execute(): List<Section> = listOf(
        Section("Section 1 Name", "section_1_codename"),
        Section("Section 2 Name", "section_2_codename"),
        Section("Section 3 Name", "section_3_codename"),
    )
}