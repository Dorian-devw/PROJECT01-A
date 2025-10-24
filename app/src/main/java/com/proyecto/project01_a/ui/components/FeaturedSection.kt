package com.proyecto.project01_a.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.data.repository.DecidePeruRepository

@Composable
fun FeaturedSection(
    onCandidateClick: (String) -> Unit,
    onViewFullSourceClick: (String) -> Unit
) {
    val destacados = DecidePeruRepository.getCandidatosDestacados()
    val sourceUrl = DecidePeruRepository.getEncuestaFuenteUrl()

    Column(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Líderes en Encuestas",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Según IPSOS", // Subtítulo/Fuente
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // ENLACE "VER COMPLETO"
            Row(
                modifier = Modifier
                    .clickable { onViewFullSourceClick(sourceUrl) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ver Completo",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelMedium,
                    textDecoration = TextDecoration.Underline
                )
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Ver encuesta completa",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(14.dp)
                        .padding(start = 4.dp)
                )
            }
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
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