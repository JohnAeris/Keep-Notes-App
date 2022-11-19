package com.example.keepnotes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = White,
    primaryVariant = Granny_Smith_Apple,
    secondary = Nyanza,
    secondaryVariant = Lapis_Lazuli,
    background = Charcoal
)

private val LightColorPalette = lightColors(
    primary = Black,
    primaryVariant = Dar_Sky_Blue,
    secondary = Charcoal,
    secondaryVariant = Lapis_Lazuli,
    background = White

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