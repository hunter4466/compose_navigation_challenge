package com.ravnnerdery.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ravnnerdery.data.database.models.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 4, exportSchema = false)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}