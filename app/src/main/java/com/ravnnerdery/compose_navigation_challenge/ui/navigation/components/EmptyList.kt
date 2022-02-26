package com.ravnnerdery.compose_navigation_challenge.ui.navigation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmptyList(message: String) {
    Card(
        elevation = 12.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .height(32.dp)
        ) {
            Text(text = message)
        }
    }
}