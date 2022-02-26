package com.ravnnerdery.compose_navigation_challenge.ui.navigation

import LoadingScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.ImageLoader
import com.ravnnerdery.compose_navigation_challenge.ui.navigation.components.Articles
import com.ravnnerdery.compose_navigation_challenge.ui.navigation.components.Drawer
import com.ravnnerdery.compose_navigation_challenge.ui.navigation.components.DrawerTopBar
import com.ravnnerdery.domain.models.Article
import com.ravnnerdery.domain.models.Section
import com.ravnnerdery.domain.models.Tag

@Composable
fun Navigation(
    onDrawerTopBarButtonClicked: () -> Unit = {},
    onDrawerButtonClicked: (String, String) -> Unit,
    tagTitle: String,
    isDrawerActive: Boolean,
    tagList: List<Tag>,
    tagFilter: String,
    sectionList: List<Section>,
    navController: NavHostController,
    articlesList: List<Article>,
    elementsAreLoading: Boolean,
    imageLoader: ImageLoader
) {
    Column {
        DrawerTopBar(
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { onDrawerTopBarButtonClicked() },
            title = tagTitle
        )
        if(elementsAreLoading){
            LoadingScreen(imageLoader = imageLoader)
        }else{
            if (isDrawerActive) {
                Drawer(screens = tagList,
                    onClick = { name, codeName ->
                        onDrawerButtonClicked(name, codeName)
                    })
            } else {
                Column() {
                    var selectedTabIndex by remember { mutableStateOf(0) }
                    if (sectionList.isNotEmpty()) {
                        TabRow(
                            selectedTabIndex = selectedTabIndex,
                            modifier = Modifier.height(32.dp)) {
                            sectionList.forEachIndexed { i, elm ->
                                Tab(
                                    selected = i == selectedTabIndex,
                                    onClick = {
                                        navController.navigate(elm.codeName)
                                        selectedTabIndex = i
                                    }
                                ) {
                                    Text(elm.name)
                                }
                            }
                        }
                    }
                    NavHost(
                        navController = navController,
                        startDestination = if (sectionList.isEmpty()) "home" else sectionList.first().codeName
                    ) {
                        composable("home") { Articles(tagFilter, "home", articlesList) }
                        sectionList.forEach { section ->
                            composable(section.codeName) {
                                Articles(
                                    tagFilter,
                                    section.codeName,
                                    articlesList
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
