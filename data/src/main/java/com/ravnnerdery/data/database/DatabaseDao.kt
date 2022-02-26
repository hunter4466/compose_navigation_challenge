package com.ravnnerdery.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ravnnerdery.data.database.models.ArticleEntity

@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArticle(article: ArticleEntity)

    @Query("SELECT * FROM articles_table")
    fun getAllArticles(): List<ArticleEntity>

}