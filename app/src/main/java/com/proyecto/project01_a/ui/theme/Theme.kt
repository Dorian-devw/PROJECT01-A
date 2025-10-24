package com.proyecto.project01_a.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val PrimaryBlue = Color(0xFF0097D0)
val SecondaryBlue = Color(0xFF137FDD)
val DarkerBlue = Color(0xFF00679D)
val LighterBlue = Color(0xFFC7E6F4)
val PeruWhite = Color(0xFFFFFFFF)
val LightGray = Color(0xFFF5F5F5)
val DarkGray = Color(0xFF424242)
val TextPrimary = Color(0xFF212121)
val TextSecondary = Color(0xFF757575)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = PeruWhite,
    primaryContainer = LighterBlue,
    onPrimaryContainer = DarkerBlue,

    secondary = SecondaryBlue,
    onSecondary = PeruWhite,

    // Colores de Superficie y Fondo (Se mantienen)
    background = PeruWhite,
    onBackground = TextPrimary,
    surface = PeruWhite,
    onSurface = TextPrimary,
    surfaceVariant = LightGray,
    onSurfaceVariant = TextSecondary,

    // Error se mantiene
    error = Color(0xFFB00020),
    onError = PeruWhite
)

private val DarkColorScheme = darkColorScheme(
    // Colores Primarios (Azul)
    primary = PrimaryBlue,
    onPrimary = PeruWhite,
    primaryContainer = DarkerBlue,
    onPrimaryContainer = PeruWhite,

    secondary = SecondaryBlue,
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