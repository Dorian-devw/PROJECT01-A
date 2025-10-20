package com.proyecto.project01_a.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.data.repository.DecidePeruRepository
import com.proyecto.project01_a.ui.components.TopBar

@Composable
fun EducacionDetailScreen(
    educacionId: String,
    onNavigateBack: () -> Unit
) {
    // 1. Obtener el contenido del repositorio
    val contenido = DecidePeruRepository.getContenidoEducativoDetail(educacionId)

    Scaffold(
        topBar = {
            // El título de la TopBar puede ser el título del contenido o un fallback
            TopBar(
                title = contenido?.titulo ?: "Detalle Educativo",
                onNavigateBack = onNavigateBack
            )
        }
    ) { paddingValues ->
        if (contenido != null) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Título y Categoría (redundante, pero estético)
                item {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = contenido.titulo,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        AssistChip(
                            onClick = {},
                            label = { Text(contenido.categoria) },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                        Divider(
                            modifier = Modifier.padding(vertical = 12.dp),
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                    }
                }

                // Contenido Principal (Texto largo)
                item {
                    Text(
                        text = contenido.contenido,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

            }
        } else {
            // Manejo de error o contenido no encontrado
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text(
                    text = "Contenido no encontrado. ID: $educacionId",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}
