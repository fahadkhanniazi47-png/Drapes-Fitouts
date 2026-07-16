package com.example.ui.theme

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
    primary = BentoPrimaryDark,
    secondary = BentoSecondaryDark,
    tertiary = BentoTertiaryDark,
    background = BentoBackgroundDark,
    surface = BentoSurfaceDark,
    onPrimary = BentoBackgroundDark,
    onSecondary = BentoBackgroundDark,
    onTertiary = BentoBackgroundDark,
    onBackground = BentoTextDark,
    onSurface = BentoTextDark
)

private val LightColorScheme = lightColorScheme(
    primary = BentoPrimaryLight,
    secondary = BentoSecondaryLight,
    tertiary = BentoTertiaryLight,
    background = BentoBackgroundLight,
    surface = BentoSurfaceLight,
    onPrimary = BentoBackgroundLight,
    onSecondary = BentoBackgroundLight,
    onTertiary = BentoBackgroundLight,
    onBackground = BentoTextLight,
    onSurface = BentoTextLight
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Disable dynamic colors to enforce the custom Bento Grid brand theme
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
