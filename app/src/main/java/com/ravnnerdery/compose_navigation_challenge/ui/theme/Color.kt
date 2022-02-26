package com.ravnnerdery.compose_navigation_challenge.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val brown700 = Color(color = 0xFF5D4037)
val brown800 = Color(color = 0xFF4E342E)
val brown900 = Color(color = 0xFF3E2723)
val brown200 = Color(color = 0xFFBCAAA4)
val brown300 = Color(color = 0xFFA1887F)

val DarkColors = darkColors(
    primary = brown300,
    primaryVariant = brown700,
    onPrimary = Color.Black,
    secondary = brown300,
    onSecondary = Color.Black,
    error = brown200
)

val LightColors = lightColors(
    primary = brown700,
    primaryVariant = brown900,
    onPrimary = Color.White,
    secondary = brown700,
    secondaryVariant = brown900,
    onSecondary = Color.White,
    error = brown800
)

