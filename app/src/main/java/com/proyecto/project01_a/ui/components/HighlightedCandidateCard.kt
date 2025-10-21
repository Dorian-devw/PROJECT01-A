package com.proyecto.project01_a.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.data.model.CandidatoDestacado

@Composable
fun HighlightedCandidateCard(
    candidato: CandidatoDestacado,
    onClick: (String) -> Unit
) {
    // Dimensiones óptimas para la imagen destacada (Ejemplo: 120x120)
    val imageSize = 120.dp
    val cornerRadius = 8.dp

    Column(
        modifier = Modifier
            .width(imageSize + 10.dp) // Ancho un poco mayor que la imagen para el texto
            .clickable { onClick(candidato.id) }
    ) {
        // 1. IMAGEN CUADRADA CON BORDES
        Image(
            painter = painterResource(id = candidato.imagenResId),
            contentDescription = "Foto de ${candidato.nombre}",
            contentScale = ContentScale.Crop, // Para llenar el cuadrado sin distorsionar (acepta recorte)
            modifier = Modifier
                .size(imageSize) // Tamaño Fijo CUADRADO
                .clip(RoundedCornerShape(cornerRadius))
        )
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