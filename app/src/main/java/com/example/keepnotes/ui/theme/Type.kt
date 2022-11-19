package com.example.keepnotes.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.keepnotes.R

// Set of Material typography styles to start with

val Sono = FontFamily(Font(R.font.sono))
val RobotoBold = FontFamily(Font(R.font.roboto_condensed_bold))
val RobotoBoldItalic = FontFamily(Font(R.font.roboto_condensed_bold_italic))
val RobotoNormal = FontFamily(Font(R.font.roboto_condensed_regular))
val RobotoItalic = FontFamily(Font(R.font.roboto_condensed_italic))
val RobotoLight = FontFamily(Font(R.font.roboto_condensed_light))
val RobotoLightItalic = FontFamily(Font(R.font.roboto_condensed_light_italic))

val Typography = Typography(

    h1 = TextStyle(
        fontFamily = RobotoBold,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp
    ),

    h2 = TextStyle(
        fontFamily = RobotoBold,
        fontSize = 16.sp
    ),

    body1 = TextStyle(
        fontFamily = Sono,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    caption = TextStyle(
        fontFamily = RobotoLightItalic,
        fontSize = 10.sp
    ),

    button = TextStyle(
        fontFamily = RobotoNormal,
        fontSize = 16.sp
    ),



)