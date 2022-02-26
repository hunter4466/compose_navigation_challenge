package com.ravnnerdery.compose_navigation_challenge.ui.navigation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ravnnerdery.domain.models.Article

@Composable
fun Articles(
    tagFilter: String,
    sectionId: String,
    content: List<Article>
) {

    val filteredContent = content.filter {
        it.sectionId == sectionId && it.tagsList.contains(tagFilter)
    }

    LazyColumn {
        if (filteredContent.isNotEmpty()) {
            itemsIndexed(filteredContent) { index, article ->
                SingleArticle(article)
            }
        } else {
            item {
                EmptyList("Not articles found in this section with this tag")
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SingleArticle(article: Article) {
    var showMore by rememberSaveable { mutableStateOf(false) }
    Card(
        elevation = 12.dp,
        modifier = Modifier.padding(8.dp),
        onClick = { showMore = !showMore }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = article.headline,
                style = MaterialTheme.typography.h5,
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = article.trailText,
                style = MaterialTheme.typography.h6,
            )
            Spacer(Modifier.height(12.dp))
            if (showMore) {
                Text(
                    text = article.body,
                    style = MaterialTheme.typography.body1,
                )
                Text(text = "Show less")
            } else {
                Text(text = "Show more...")
            }
        }
    }
}