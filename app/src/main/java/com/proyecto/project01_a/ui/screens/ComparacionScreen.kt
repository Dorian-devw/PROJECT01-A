package com.proyecto.project01_a.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.proyecto.project01_a.data.model.Candidato
import com.proyecto.project01_a.data.repository.DecidePeruRepository

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ComparacionScreen(
    candidatoIds: List<String>,
    onNavigateBack: () -> Unit
) {
    // 1. Recuperación de Datos
    val candidatosAComparar = candidatoIds.mapNotNull { id ->
        DecidePeruRepository.getCandidatoById(id)
    }.take(3)

    if (candidatosAComparar.isEmpty()) {
        EmptyComparisonState(onNavigateBack)
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Comparar Candidatos",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) { paddingValues ->
        val listState = rememberLazyListState()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
                .padding(paddingValues)
        ) {

            // ENCABEZADO CON TARJETAS DE CANDIDATOS
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f),
                                    Color.Transparent
                                )
                            )
                        )
                        .padding(horizontal = 12.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    candidatosAComparar.forEach { candidato ->
                        CandidatoHeaderItem(candidato, Modifier.weight(1f))
                    }
                }
            }

            // SECCIÓN 1: DATOS BÁSICOS
            stickyHeader {
                ComparisonSectionHeader("📋 Datos Básicos")
            }
            item {
                ComparisonCard {
                    ComparisonRow("Edad", candidatosAComparar.map { "${it.edad} años" })
                    ComparisonRow("Profesión", candidatosAComparar.map { it.profesion })
                    ComparisonRow("Región", candidatosAComparar.map { it.region }, isLast = true)
                }
            }

            // SECCIÓN 2: INTEGRIDAD Y ANTECEDENTES
            stickyHeader {
                ComparisonSectionHeader("⚖️ Integridad y Antecedentes")
            }
            item {
                ComparisonCard {
                    ComparisonRow(
                        "Denuncias",
                        candidatosAComparar.map { if (it.denuncias.isNotEmpty()) "Sí (${it.denuncias.size})" else "No" },
                        emphasizeNegative = true
                    )
                    ComparisonRow(
                        "Transparencia Financiera",
                        candidatosAComparar.map { it.financiamiento.transparencia },
                        emphasizePositive = true,
                        isLast = true
                    )
                }
            }

            // SECCIÓN 3: EXPERIENCIA Y CARGOS
            stickyHeader {
                ComparisonSectionHeader("💼 Experiencia Pública")
            }
            item {
                ComparisonCard {
                    ComparisonRow(
                        "Último Cargo",
                        candidatosAComparar.map { it.historial.firstOrNull()?.cargo ?: "Sin historial reciente" },
                        isLast = true
                    )
                }
            }

            // SECCIÓN 4: PROPUESTAS
            stickyHeader {
                ComparisonSectionHeader("🎯 Propuestas Prioritarias")
            }
            item {
                ComparisonCard {
                    ComparisonRow(
                        "Prioridad Principal",
                        candidatosAComparar.map { it.propuestas.firstOrNull()?.prioridad ?: "N/A" },
                        isLast = true
                    )
                }
            }

            item { Spacer(Modifier.height(24.dp)) }
        }
    }
}

// COMPONENTES REUTILIZABLES

@Composable
fun ComparisonSectionHeader(title: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(8.dp),
        tonalElevation = 2.dp
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun ComparisonCard(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 1.dp,
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            content()
        }
    }
}

@Composable
fun ComparisonRow(
    label: String,
    values: List<String>,
    emphasizePositive: Boolean = false,
    emphasizeNegative: Boolean = false,
    isLast: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            values.forEach { value ->
                val (color, containerColor) = when {
                    emphasizeNegative && value.contains("Sí") ->
                        MaterialTheme.colorScheme.error to MaterialTheme.colorScheme.errorContainer
                    emphasizePositive && (value.contains("Alta") || value == "No") ->
                        MaterialTheme.colorScheme.primary to MaterialTheme.colorScheme.primaryContainer
                    else ->
                        MaterialTheme.colorScheme.onSurface to MaterialTheme.colorScheme.surfaceVariant
                }

                Surface(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    color = containerColor.copy(alpha = 0.3f)
                ) {
                    Text(
                        text = value,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp),
                        textAlign = TextAlign.Center,
                        color = color,
                        fontWeight = if (emphasizePositive || emphasizeNegative) FontWeight.SemiBold else FontWeight.Normal
                    )
                }
            }
        }
        if (!isLast) {
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun CandidatoHeaderItem(candidato: Candidato, modifier: Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 3.dp,
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f),
                modifier = Modifier.padding(4.dp)
            ) {
                AsyncImage(
                    model = candidato.fotoUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = candidato.nombre.split(" ").firstOrNull() ?: "",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
            Text(
                text = candidato.partido,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                maxLines = 2,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun EmptyComparisonState(onNavigateBack: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.Warning,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f)
            )
            Spacer(Modifier.height(24.dp))
            Text(
                "No se encontraron candidatos válidos para comparar",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Selecciona candidatos desde la lista principal",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(32.dp))
            Button(
                onClick = onNavigateBack,
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text("Volver a la Lista")
            }
        }
    }
}