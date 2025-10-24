package com.proyecto.project01_a.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.proyecto.project01_a.data.model.Partido
import com.proyecto.project01_a.data.repository.DecidePeruRepository
import com.proyecto.project01_a.ui.components.SectionTitle
import com.proyecto.project01_a.ui.components.TopBar


@Composable
fun PartidoDetailScreen(
    partidoId: String,
    onNavigateBack: () -> Unit
) {
    val partido = DecidePeruRepository.getPartidoById(partidoId)

    Scaffold(
        topBar = {
            TopBar(
                title = partido?.nombreCorto ?: "Detalle del Partido",
                onNavigateBack = onNavigateBack
            )
        }
    ) { paddingValues ->
        if (partido != null) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    PartidoHeader(partido = partido)
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    SectionTitle(
                        title = "Descripción y Fundamentos",
                        icon = Icons.Default.Info
                    )
                    Text(
                        text = partido.descripcion,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        DetailChip(
                            icon = Icons.Default.Public,
                            label = "Ideología: ${partido.ideologia}",
                            modifier = Modifier.weight(1f)
                        )
                        DetailChip(
                            icon = Icons.Default.DateRange,
                            label = "Fundación: ${partido.fundacion}",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                item {
                    SectionTitle(
                        title = "Liderazgo",
                        icon = Icons.Default.Star
                    )
                    DetailRow(
                        icon = Icons.Default.Person,
                        label = "Líder Actual:",
                        value = partido.lider
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }

                item {
                    SectionTitle(
                        title = "Miembros Destacados",
                        icon = Icons.Default.Groups
                    )
                }
                items(partido.miembrosDestacados) { miembro ->
                    DetailRow(
                        icon = Icons.Default.ArrowRight,
                        label = miembro,
                        value = ""
                    )
                }

                item {
                    SectionTitle(
                        title = "Propuestas Clave",
                        icon = Icons.Default.Policy
                    )
                }
                items(partido.propuestasGenerales) { propuesta ->
                    DetailRow(
                        icon = Icons.Default.CheckCircle,
                        label = propuesta,
                        value = "",
                        valueColor = MaterialTheme.colorScheme.primary
                    )
                }

                partido.webOficial?.let { web ->
                    item {
                        DetailRow(
                            icon = Icons.Default.Language,
                            label = "Web Oficial:",
                            value = web
                        )
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Partido Político no encontrado.",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}



@Composable
fun PartidoHeader(partido: Partido) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(partido.logoUrl),
            contentDescription = "Logo de ${partido.nombreCorto}",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = partido.nombre,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = partido.nombreCorto,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun DetailRow(icon: ImageVector, label: String, value: String, valueColor: Color = MaterialTheme.colorScheme.onSurface) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = if (value.isNotEmpty()) FontWeight.SemiBold else FontWeight.Normal
        )
        if (value.isNotEmpty()) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = valueColor,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun DetailChip(icon: ImageVector, label: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(56.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
