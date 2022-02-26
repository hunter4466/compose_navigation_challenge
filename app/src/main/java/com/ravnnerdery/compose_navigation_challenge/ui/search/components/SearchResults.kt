package com.ravnnerdery.compose_navigation_challenge.ui.search.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.ravnnerdery.compose_navigation_challenge.ui.navigation.components.EmptyList
import com.ravnnerdery.compose_navigation_challenge.ui.navigation.components.SingleArticle
import com.ravnnerdery.domain.models.Article

@Composable
fun SearchResults(
    userSearchState: String,
    articlesList: List<Article>,
) {

    val filteredResult = articlesList.filter {
        it.body.contains(userSearchState)
    }

    LazyColumn {
        if (userSearchState.isEmpty()) {
            item {
                EmptyList(
                    message = "No Results found"
                )
            }
        } else {
            if (filteredResult.isEmpty()) {
                item {
                    EmptyList(
                        message = "No Results found"
                    )
                }
            } else {
                filteredResult.forEach { article ->
                    item {
                        SingleArticle(article)
                    }
                }
            }
        }
    }
}
