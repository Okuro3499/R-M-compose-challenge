package com.compose.rmcomposechallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.compose.rmcomposechallenge.R

val abfont = FontFamily(
    listOf(Font(R.font.boldaboutfont))
)

val afont = FontFamily(
    listOf(Font(R.font.aboutfont))
)

val Typography = Typography(
    h6 = TextStyle(
        fontSize = 16.sp,
        fontFamily = afont,
        fontWeight = FontWeight.Normal,
        color = Color.White
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = abfont,
        fontSize = 20.sp,
        color = Color.White
    ),
// Set of Material typography styles to start with

    h5 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h4 =  TextStyle(
        fontSize = 18.sp,
        fontFamily = afont,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)