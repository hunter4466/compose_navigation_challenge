package com.ravnnerdery.compose_navigation_challenge.ui.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchIcon(
    onSearchIconClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
    ) {
        IconButton(
            onClick = { onSearchIconClick() }
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                modifier = Modifier,
                contentDescription = "Search",
                tint = MaterialTheme.colors.background,
            )
        }
    }
}
