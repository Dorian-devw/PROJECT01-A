package com.proyecto.project01_a.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface // <-- Importación necesaria
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color // <-- Importación necesaria
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.data.model.CandidatoDestacado
import coil.compose.AsyncImage // <-- ¡IMPORTAR ESTO PARA USAR URLS!

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

@Composable
fun HighlightedCandidateCard(
    candidato: CandidatoDestacado,
    onClick: (String) -> Unit
) {
    val imageSize = 120.dp
    val cornerRadius = 8.dp

    Column(
        modifier = Modifier
            .width(imageSize + 10.dp)
            .clickable { onClick(candidato.id) }
    ) {
        // 1. IMAGEN y BADGE (Ahora usamos Box para superponer elementos)
        Box(
            modifier = Modifier
                .size(imageSize)
                .clip(RoundedCornerShape(cornerRadius))
        ) {
            // A. IMAGEN
            AsyncImage( // <-- CAMBIO CLAVE AQUÍ
                // model acepta la String de la URL
                model = candidato.imagenUrl,
                contentDescription = "Foto de ${candidato.nombre}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            // B. PORCENTAJE BADGE
            Surface(
                // Fondo oscuro semi-transparente para que el texto resalte
                color = Color.Black.copy(alpha = 0.6f),
                // Forma de etiqueta biselada en la esquina
                shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 8.dp),
                // Alineación en la esquina superior izquierda
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = candidato.porcentaje,
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))

        // 2. Nombre del Candidato (Negrita)
        Text(
            text = candidato.nombre,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        // 3. Partido Político
        Text(
            text = candidato.partido,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}