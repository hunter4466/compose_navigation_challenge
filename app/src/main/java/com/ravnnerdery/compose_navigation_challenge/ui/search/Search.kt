package com.ravnnerdery.compose_navigation_challenge.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ravnnerdery.compose_navigation_challenge.ui.search.components.SearchResults
import com.ravnnerdery.compose_navigation_challenge.ui.search.components.SearchTopBar
import com.ravnnerdery.domain.models.Article

@Composable
fun Search(
    userSearchState: String,
    onSearchTextChanged: (String) -> Unit = {},
    onClearClick: () -> Unit = {},
    onNavigateBack: () -> Unit = {},
    articlesList: List<Article>
) {
    Column {
        SearchTopBar(
            searchText = userSearchState,
            placeHolderText = "Search articles",
            onSearchTextChanged = { onSearchTextChanged(it) },
            onClearClick = { onClearClick() },
            onNavigateBack = { onNavigateBack() }
        )
        SearchResults(
            userSearchState = userSearchState,
            articlesList = articlesList,
        )
    }
}
