package com.example.keepnotes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = White,
    primaryVariant = Outer_Space,
    secondary = Nyanza,
    secondaryVariant = Dar_Sky_Blue,
    background = Charcoal,
    surface = Granny_Smith_Apple,
    onSurface = Cyan_Blue_Azure
)

private val LightColorPalette = lightColors(
    primary = Black,
    primaryVariant = White,
    secondary = Charcoal,
    secondaryVariant = Dar_Sky_Blue,
    background = White,
    surface = Lapis_Lazuli,
    onSurface = Light_Yellow

)

@Composable
fun KeepNotesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}