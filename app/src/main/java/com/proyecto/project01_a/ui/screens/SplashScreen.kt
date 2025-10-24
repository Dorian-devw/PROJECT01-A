package com.proyecto.project01_a.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HowToVote
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.proyecto.project01_a.ui.components.CustomButton
import com.proyecto.project01_a.ui.theme.PeruWhite
// 🚨 CORRECCIÓN: Cambiar la importación de DecidePeruDarkBlue a DarkerBlue
import com.proyecto.project01_a.ui.theme.DarkerBlue
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNavigateToHome: () -> Unit
) {
    var showButton by remember { mutableStateOf(false) }
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")

    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )

    LaunchedEffect(Unit) {
        delay(1500)
        showButton = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        // 🚨 CORRECCIÓN CLAVE: Usar DarkerBlue
                        DarkerBlue,
                        DarkerBlue.copy(alpha = 0.85f)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // ÍCONO
            Icon(
                imageVector = Icons.Default.HowToVote,
                contentDescription = "DecidePerú Logo",
                modifier = Modifier
                    .size(120.dp)
                    .alpha(alpha),
                tint = PeruWhite // Icono blanco para contrastar con fondo azul oscuro
            )

            Spacer(modifier = Modifier.height(32.dp))

            // TÍTULO
            Text(
                text = "DecidePerú",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                color = PeruWhite, // Texto blanco
                fontSize = 48.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // SLOGAN
            Text(
                text = "Conoce, compara y decide con conciencia",
                style = MaterialTheme.typography.titleMedium,
                color = PeruWhite.copy(alpha = 0.9f), // Texto blanco
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // VERSIÓN
            Text(
                text = "Elecciones 2026",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = PeruWhite, // Texto blanco
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(64.dp))

            // BOTÓN
            if (showButton) {
                CustomButton(
                    text = "Comenzar",
                    onClick = onNavigateToHome,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}