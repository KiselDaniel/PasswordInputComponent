package com.dado.passwordinputcomponent.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = colorSurfaceBrand,
    onPrimary = colorSurfaceXLow,
    primaryContainer = colorSurfaceBrand,
    onPrimaryContainer = colorSurfaceXLow,

    secondary = colorContentOnNeutralMedium,
    onSecondary = colorContentOnNeutralXxHigh,
    secondaryContainer = colorSurfaceXHigh,
    onSecondaryContainer = colorContentOnNeutralMedium,

    tertiary = colorSurfaceWarning,
    onTertiary = colorContentOnNeutralXxHigh,
    tertiaryContainer = colorSurfaceWarningVariant,
    onTertiaryContainer = colorSurfaceWarning,

    error = colorSurfaceDanger,
    onError = colorSurfaceXLow,
    errorContainer = colorSurfaceDangerVariant,
    onErrorContainer = colorSurfaceDanger,

    background = colorContentOnNeutralXxHigh,
    onBackground = colorContentOnNeutralMedium,

    surface = colorSurfaceXHigh,
    onSurface = colorContentOnNeutralMedium,

    surfaceVariant = colorContentOnNeutralXxHigh,
    onSurfaceVariant = colorContentOnNeutralLow,

    outline = colorContentOnNeutralMedium,
)

private val LightColorScheme = lightColorScheme(
    primary = colorSurfaceBrand,
    onPrimary = colorSurfaceXLow,
    primaryContainer = colorSurfaceBrand,
    onPrimaryContainer = colorSurfaceXLow,

    secondary = colorContentOnNeutralMedium,
    onSecondary = colorSurfaceXLow,
    secondaryContainer = colorContentOnNeutralLow,
    onSecondaryContainer = colorContentOnNeutralXxHigh,

    tertiary = colorSurfaceWarning,
    onTertiary = colorSurfaceXLow,
    tertiaryContainer = colorSurfaceWarningVariant,
    onTertiaryContainer = colorSurfaceWarning,

    error = colorSurfaceDanger,
    onError = colorSurfaceXLow,
    errorContainer = colorSurfaceDangerVariant,
    onErrorContainer = colorSurfaceDanger,

    background = colorSurfaceXLow,
    onBackground = colorContentOnNeutralXxHigh,

    surface = colorSurfaceXLow,
    onSurface = colorContentOnNeutralXxHigh,

    surfaceVariant = colorContentOnNeutralLow,
    onSurfaceVariant = colorContentOnNeutralXxHigh,

    outline = colorContentOnNeutralMedium,
)

@Composable
fun LoginPasswordComponentTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (useDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        useDarkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
