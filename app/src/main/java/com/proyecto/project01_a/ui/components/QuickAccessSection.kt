package com.proyecto.project01_a.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import com.proyecto.project01_a.R

val QuickAccessCardColor = Color(0xFFE7EEEE)

@Composable
fun QuickAccessSection(
    onNavigateToCandidatosList: () -> Unit,
    onNavigateToPartidos: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        QuickAccessCard(
            title = "Candidatos",
            description = "Conoce sus propuestas y trayectoria",
            iconResId = R.drawable.habilidades,
            backgroundColor = QuickAccessCardColor,
            modifier = Modifier.weight(1f),
            onClick = onNavigateToCandidatosList
        )

        Spacer(modifier = Modifier.width(16.dp))

        QuickAccessCard(
            title = "Partidos",
            description = "Descubre su historia e ideología",
            iconResId = R.drawable.partidopolitico,
            backgroundColor = QuickAccessCardColor,
            modifier = Modifier.weight(1f),
            onClick = onNavigateToPartidos
        )
    }
}

