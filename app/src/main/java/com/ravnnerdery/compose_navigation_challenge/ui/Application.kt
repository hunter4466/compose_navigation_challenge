package com.ravnnerdery.compose_navigation_challenge.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import com.ravnnerdery.compose_navigation_challenge.application.MainViewModel
import com.ravnnerdery.compose_navigation_challenge.ui.navigation.Navigation
import com.ravnnerdery.compose_navigation_challenge.ui.search.Search
import com.ravnnerdery.compose_navigation_challenge.ui.search.SearchIcon

@Composable
fun Application(viewModel: MainViewModel, imageLoader: ImageLoader) {

    val articlesList by viewModel.articlesListFlow.collectAsState(initial = emptyList())
    val elementsAreLoading by viewModel.elementsAreLoadingFlow.collectAsState(initial = true)
    val tagList by remember { mutableStateOf(viewModel.tagsList) }
    val sectionList by remember { mutableStateOf(viewModel.sectionsList) }
    var isDrawerActive by remember { mutableStateOf(false) }
    var tagFilter by remember { mutableStateOf(tagList.first().codeName) }
    var tagTitle by remember { mutableStateOf(tagList.first().name) }
    val navController = rememberNavController()
    var searchBarState by remember { mutableStateOf(false) }
    var userSearchState by remember { mutableStateOf("") }

    if (searchBarState) {
        Search(
            userSearchState = userSearchState,
            onSearchTextChanged = { userSearchState = it },
            onClearClick = { userSearchState = "" },
            onNavigateBack = { searchBarState = false },
            articlesList = articlesList
        )
    } else {
        Navigation(
            onDrawerTopBarButtonClicked = {
                isDrawerActive = !isDrawerActive
            },
            onDrawerButtonClicked = { name, codeName ->
                tagFilter = codeName
                tagTitle = name
                isDrawerActive = !isDrawerActive
            },
            tagTitle = tagTitle,
            isDrawerActive = isDrawerActive,
            tagList = tagList,
            tagFilter = tagFilter,
            sectionList = sectionList,
            navController = navController,
            articlesList = articlesList,
            imageLoader = imageLoader,
            elementsAreLoading = elementsAreLoading,
        )
        SearchIcon(
            onSearchIconClick = { searchBarState = true }
        )
    }

}
