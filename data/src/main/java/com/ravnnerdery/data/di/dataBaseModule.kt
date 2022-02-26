package com.ravnnerdery.data.di

import android.content.Context
import androidx.room.Room
import com.ravnnerdery.data.database.ArticlesDatabase
import com.ravnnerdery.data.database.DatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val ARTICLES_DATABASE = "ArticlesDabase"

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabaseDao(articlesDatabase: ArticlesDatabase): DatabaseDao {
        return articlesDatabase.databaseDao()
    }

    @Provides
    @Singleton
    fun provideArticlesDatabase(@ApplicationContext appContext: Context): ArticlesDatabase {
        return Room.databaseBuilder(
            appContext,
            ArticlesDatabase::class.java,
            ARTICLES_DATABASE
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}