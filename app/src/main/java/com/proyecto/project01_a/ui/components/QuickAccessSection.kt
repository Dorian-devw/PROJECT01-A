package com.proyecto.project01_a.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import com.proyecto.project01_a.R

val QuickAccessCardColor = Color(0xFFE7EEEE) // Color de fondo E7EEEE

@Composable
fun QuickAccessSection(
    onNavigateToCandidatosList: () -> Unit,
    onNavigateToPartidos: () -> Unit // Navegación para Partidos Políticos (aún sin datos)
) {
    // Usamos un Row para colocar las tarjetas horizontalmente
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // --- TARJETA IZQUIERDA: Candidatos ---
        QuickAccessCard(
            title = "Candidatos",
            description = "Conoce sus propuestas y trayectoria",
            iconResId = R.drawable.habilidades, // Ahora R.drawable.habilidades es válido
            backgroundColor = QuickAccessCardColor,
            modifier = Modifier.weight(1f), // Ocupa la mitad del espacio
            onClick = onNavigateToCandidatosList // Navegación a la lista de Candidatos
        )

        Spacer(modifier = Modifier.width(16.dp)) // Espacio entre tarjetas

        // --- TARJETA DERECHA: Partidos Políticos ---
        QuickAccessCard(
            title = "Partidos",
            description = "Descubre su historia e ideología",
            iconResId = R.drawable.partidopolitico, // Ahora R.drawable.partidos es válido
            backgroundColor = QuickAccessCardColor,
            modifier = Modifier.weight(1f), // Ocupa la otra mitad
            onClick = onNavigateToPartidos // Navegación a Partidos Políticos
        )
    }
}

