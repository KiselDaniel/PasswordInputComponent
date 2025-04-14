package com.dado.passwordinputcomponent.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dado.passwordinputcomponent.R

 val InterFontFamily = FontFamily(
    Font(R.font.inter, FontWeight.W400),
    Font(R.font.inter, FontWeight.W500),
 )

// Label M: font.label.m
val LabelMStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.W500,
    fontSize = 16.sp,
    lineHeight = 22.sp,
    letterSpacing = 0.1.sp
)

// Label S: font.label.s
val LabelSStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp,
    lineHeight = 17.sp,
    letterSpacing = 0.16.sp
)

// Body M: font.body.m
val BodyMStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.W400,
    fontSize = 16.sp,
    lineHeight = 22.sp,
    letterSpacing = 0.01.sp
)

val AppTypography = Typography(
    bodyMedium = BodyMStyle,          // Default text
    labelMedium = LabelMStyle,        // Input field labels, larger buttons
    labelSmall = LabelSStyle,         // Smaller labels, error messages, captions
)
