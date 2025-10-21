package com.proyecto.project01_a.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.data.repository.DecidePeruRepository

@Composable
fun FeaturedSection(
    onCandidateClick: (String) -> Unit
) {
    // 1. Obtener los datos (listo para ser escalable)
    val destacados = DecidePeruRepository.getCandidatosDestacados()

    Column(modifier = Modifier.fillMaxWidth()) {

        // 2. Título: Destacadas (Negrita)
        Text(
            text = "Destacadas",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        // 3. LazyRow para el Scroll Horizontal
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp) // Espacio entre tarjetas
        ) {
            items(destacados) { candidato ->
                HighlightedCandidateCard(
                    candidato = candidato,
                    onClick = onCandidateClick
                )
            }
        }
    }
}