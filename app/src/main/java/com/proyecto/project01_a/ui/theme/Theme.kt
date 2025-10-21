package com.proyecto.project01_a.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Colores definidos arriba
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
    // Colores Primarios (Azul)
    primary = PrimaryBlue,          // Azul fuerte para botones principales, iconos, etc.
    onPrimary = PeruWhite,          // Texto blanco sobre el azul primario
    primaryContainer = LighterBlue, // Fondo celeste claro para tarjetas o chips de acento
    onPrimaryContainer = DarkerBlue, // Texto oscuro sobre el container claro

    // Colores Secundarios (Un acento o el DarkGray si lo prefieres)
    secondary = SecondaryBlue,       // Azul similar para acentos visuales secundarios
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
    primaryContainer = DarkerBlue,   // Contenedor primario es un azul más oscuro
    onPrimaryContainer = PeruWhite,

    // Colores Secundarios (Acento)
    secondary = SecondaryBlue,
    onSecondary = PeruWhite,

    // Colores de Superficie y Fondo (Oscuros)
    background = Color(0xFF121212),
    onBackground = Color(0xFFE0E0E0),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE0E0E0),
    surfaceVariant = Color(0xFF2C2C2C),
    onSurfaceVariant = Color(0xFFBDBDBD),

    // Error se mantiene
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
        typography = Typography, // Asegúrate de que Typography esté definido en Types.kt
        content = content
    )
}