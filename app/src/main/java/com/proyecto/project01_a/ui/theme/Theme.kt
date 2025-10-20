package com.proyecto.project01_a.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Colores patrios peruanos
val PeruRed = Color(0xFFD32F2F)
val PeruRedDark = Color(0xFFB71C1C)
val PeruWhite = Color(0xFFFFFFFF)
val LightGray = Color(0xFFF5F5F5)
val MediumGray = Color(0xFFE0E0E0)
val DarkGray = Color(0xFF424242)
val TextPrimary = Color(0xFF212121)
val TextSecondary = Color(0xFF757575)

private val LightColorScheme = lightColorScheme(
    primary = PeruRed,
    onPrimary = PeruWhite,
    primaryContainer = Color(0xFFFFCDD2),
    onPrimaryContainer = PeruRedDark,
    secondary = DarkGray,
    onSecondary = PeruWhite,
    background = PeruWhite,
    onBackground = TextPrimary,
    surface = PeruWhite,
    onSurface = TextPrimary,
    surfaceVariant = LightGray,
    onSurfaceVariant = TextSecondary,
    error = Color(0xFFB00020),
    onError = PeruWhite
)

private val DarkColorScheme = darkColorScheme(
    primary = PeruRed,
    onPrimary = PeruWhite,
    primaryContainer = PeruRedDark,
    onPrimaryContainer = Color(0xFFFFCDD2),
    secondary = Color(0xFF616161),
    onSecondary = PeruWhite,
    background = Color(0xFF121212),
    onBackground = Color(0xFFE0E0E0),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE0E0E0),
    surfaceVariant = Color(0xFF2C2C2C),
    onSurfaceVariant = Color(0xFFBDBDBD),
    error = Color(0xFFCF6679),
    onError = Color(0xFF000000)
)

@Composable
fun Project01ATheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}