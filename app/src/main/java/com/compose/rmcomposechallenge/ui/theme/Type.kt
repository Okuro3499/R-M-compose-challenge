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
    listOf(
        Font(R.font.boldaboutfont)
    )
)


val afont = FontFamily(
    listOf(
        Font(R.font.aboutfont)

    )
)

val fonts = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.poppins_black, weight = FontWeight.Black)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White,
        fontSize = 20.sp
    ),

    h3 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 20.sp
    ),

    h6 = TextStyle(
        fontSize = 16.sp,
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        color = Color.White

    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = fonts,
        fontSize = 20.sp,
        color = Color.White
    ),
// Set of Material typography styles to start with


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