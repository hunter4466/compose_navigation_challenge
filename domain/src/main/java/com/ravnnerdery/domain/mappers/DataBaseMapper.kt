package com.ravnnerdery.domain.mappers

interface DataBaseMapper<T : Any> {
    fun mapToDataBaseModel(): T
}