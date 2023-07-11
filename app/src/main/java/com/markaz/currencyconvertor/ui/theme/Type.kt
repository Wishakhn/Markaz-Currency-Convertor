package com.markaz.currencyconvertor.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.kaaveh.sdpcompose.ssp


//Material typography styles
val mccTypography: Typography
    @Composable
    get() = Typography(
        labelLarge = TextStyle(
            fontFamily = boldLato,
            fontWeight = FontWeight.Bold,
            fontSize = 24.ssp,
            lineHeight = 32.ssp,
            letterSpacing = 1.ssp,
            color = colorAccent
        ),
        titleLarge = TextStyle(
            fontFamily = boldLato,
            fontWeight = FontWeight.Medium,
            fontSize = 18.ssp,
            lineHeight = 28.ssp,
            letterSpacing = 0.7.sp,
            color = colorSecondary
        ),
        headlineLarge = TextStyle(
            fontFamily = boldLato,
            fontWeight = FontWeight.Medium,
            fontSize = 16.ssp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp,
            color = colorCharcoal
        ),
        bodyLarge = TextStyle(
            fontFamily = boldLato,
            fontWeight = FontWeight.Medium,
            fontSize = 14.ssp,
            lineHeight = 20.ssp,
            letterSpacing = 0.5.sp,
            color = colorSecondary
        ),
        displayLarge = TextStyle(
            fontFamily = blackLato,
            fontWeight = FontWeight.Medium,
            fontSize = 12.ssp,
            lineHeight = 18.ssp,
            letterSpacing = 0.5.sp,
            color = colorDarkGrey
        ),
        labelMedium = TextStyle(
            fontFamily = regularLato,
            fontWeight = FontWeight.Normal,
            fontSize = 20.ssp,
            lineHeight = 28.ssp,
            letterSpacing = 1.ssp,
            color = colorAccent
        ),
        headlineMedium = TextStyle(
            fontFamily = regularLato,
            fontWeight = FontWeight.Normal,
            fontSize = 16.ssp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp,
            color = colorCharcoal
        ),
        bodyMedium = TextStyle(
            fontFamily = regularLato,
            fontWeight = FontWeight.Normal,
            fontSize = 14.ssp,
            lineHeight = 20.ssp,
            letterSpacing = 0.5.sp,
            color = colorSecondary
        ),
        displayMedium = TextStyle(
            fontFamily = regularLato,
            fontWeight = FontWeight.Normal,
            fontSize = 12.ssp,
            lineHeight = 18.ssp,
            letterSpacing = 0.5.sp,
            color = colorDarkGrey
        ),
        headlineSmall = TextStyle(
            fontFamily = thinLato,
            fontWeight = FontWeight.Light,
            fontSize = 11.ssp,
            lineHeight = 17.sp,
            letterSpacing = 0.5.sp,
            color = colorCharcoal
        ),
        bodySmall = TextStyle(
            fontFamily = thinLato,
            fontWeight = FontWeight.Light,
            fontSize = 9.ssp,
            lineHeight = 13.ssp,
            letterSpacing = 0.5.sp,
            color = colorSecondary
        ),
        displaySmall = TextStyle(
            fontFamily = thinLato,
            fontWeight = FontWeight.Light,
            fontSize = 10.ssp,
            lineHeight = 15.ssp,
            letterSpacing = 0.5.sp,
            color = colorDarkGrey
        )
    )