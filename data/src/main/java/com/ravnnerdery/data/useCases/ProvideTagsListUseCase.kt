package com.ravnnerdery.data.useCases

import com.ravnnerdery.domain.models.Tag
import com.ravnnerdery.domain.repository.MainRepository
import javax.inject.Inject

interface ProvideTagsListUseCase {
    fun execute(): List<Tag>
}

class ProvideTagsListUseCaseImpl @Inject constructor(private val repo: MainRepository): ProvideTagsListUseCase {

    override fun execute(): List<Tag> {
        return repo.provideTagsList()
    }
}

class ProvideTagsListUseCaseTest : ProvideTagsListUseCase {
    override fun execute(): List<Tag> {
        return listOf(
            Tag("Tag 1 Name", "Tag_1_codename"),
            Tag("Tag 2 Name", "Tag_2_codename"),
            Tag("Tag 3 Name", "Tag_3_codename"),
        )
    }
}