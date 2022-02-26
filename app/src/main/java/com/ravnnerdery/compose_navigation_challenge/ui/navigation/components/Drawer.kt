package com.ravnnerdery.compose_navigation_challenge.ui.navigation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ravnnerdery.compose_navigation_challenge.R
import com.ravnnerdery.domain.models.Tag

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    screens: List<Tag>,
    onClick: (String, String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.android_vector_logo),
            contentDescription = "App icon"
        )
        screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            TextButton(
                onClick = { onClick(screen.name, screen.codeName) }
            ) {
                Text(
                    text = screen.name,
                    style = MaterialTheme.typography.h4,
                )
            }
        }
    }
}
