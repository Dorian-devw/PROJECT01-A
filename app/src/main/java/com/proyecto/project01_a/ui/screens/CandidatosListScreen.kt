package com.proyecto.project01_a.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.data.repository.DecidePeruRepository
import com.proyecto.project01_a.ui.components.CardCandidato
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.proyecto.project01_a.ui.theme.Project01ATheme
import java.text.Normalizer

fun String.normalizeAndLowercase(): String {
    val normalized = Normalizer.normalize(this, Normalizer.Form.NFD)
    return normalized.replace("[\\p{Mn}]".toRegex(), "").lowercase()
}

data class FilterState(
    val partido: String? = null,
    val region: String? = null,
    val hasDenuncias: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CandidatosListScreen(
    onNavigateToCandidatoDetail: (String) -> Unit,
    onNavigateToComparacion: (List<String>) -> Unit,
    onNavigateBack: () -> Unit
) {
    // RF21: Búsqueda y Filtros
    var searchText by remember { mutableStateOf("") }
    var isFilterDialogOpen by remember { mutableStateOf(false) }
    var currentFilters by remember { mutableStateOf(FilterState()) }

    // RF22: Comparación
    var isCompareMode by remember { mutableStateOf(false) }
    var candidatosAComparar by remember { mutableStateOf(setOf<String>()) }

    val todosLosCandidatos = remember { DecidePeruRepository.getCandidatosPresidenciales() }

    val candidatosFiltrados = remember(searchText, currentFilters) {
        todosLosCandidatos.filter { candidato ->
            val queryNormalized = searchText.normalizeAndLowercase()
            val textMatch = if (queryNormalized.isBlank()) {
                true
            } else {
                candidato.nombre.normalizeAndLowercase().contains(queryNormalized) ||
                        candidato.partido.normalizeAndLowercase().contains(queryNormalized) ||
                        candidato.region.normalizeAndLowercase().contains(queryNormalized)
            }

            val filterMatch = when {
                currentFilters.hasDenuncias && candidato.denuncias.isEmpty() -> false
                currentFilters.partido != null && currentFilters.partido != candidato.partido -> false
                currentFilters.region != null && currentFilters.region != candidato.region -> false
                else -> true
            }
            textMatch && filterMatch
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                "Candidatos Presidenciales",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleLarge
                            )

                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = isCompareMode && candidatosAComparar.size >= 2,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                ExtendedFloatingActionButton(
                    onClick = {
                        onNavigateToComparacion(candidatosAComparar.toList())
                        isCompareMode = false
                        candidatosAComparar = emptySet()
                    },
                    icon = { Icon(Icons.Default.CompareArrows, contentDescription = "Comparar") },
                    text = { Text("Comparar (${candidatosAComparar.size})") },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 6.dp,
                        pressedElevation = 12.dp
                    )
                )
            }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
                .padding(paddingValues)
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    OutlinedTextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        placeholder = {
                            Text(
                                "Buscar por nombre, partido o región",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Buscar",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        },
                        trailingIcon = {
                            if (searchText.isNotEmpty()) {
                                IconButton(onClick = { searchText = "" }) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Limpiar",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
                            focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // BOTÓN MODO COMPARAR
                        FilterChip(
                            selected = isCompareMode,
                            onClick = {
                                isCompareMode = !isCompareMode
                                if (!isCompareMode) { candidatosAComparar = emptySet() }
                            },
                            label = {
                                Text(
                                    if (isCompareMode) "Salir de Comparar" else "Modo Comparar",
                                    fontWeight = FontWeight.Medium
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    if (isCompareMode) Icons.Default.Close else Icons.Default.CompareArrows,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = isCompareMode,
                                borderColor = MaterialTheme.colorScheme.primary
                            ),
                            modifier = Modifier.weight(1f)
                        )

                        FilterChip(
                            selected = currentFilters != FilterState(),
                            onClick = { isFilterDialogOpen = true },
                            enabled = !isCompareMode,
                            label = {
                                Text(
                                    "Filtros",
                                    fontWeight = FontWeight.Medium
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Tune,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = !isCompareMode,
                                selected = currentFilters != FilterState(),
                                borderColor = MaterialTheme.colorScheme.outline
                            )
                        )
                    }

                    AnimatedVisibility(
                        visible = isCompareMode,
                        enter = fadeIn() + expandVertically(),
                        exit = fadeOut() + shrinkVertically()
                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.tertiaryContainer
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    Icons.Outlined.Info,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onTertiaryContainer,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    "Selecciona de 2 a 3 candidatos para comparar (${candidatosAComparar.size}/3)",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onTertiaryContainer
                                )
                            }
                        }
                    }
                }
            }

            if (isFilterDialogOpen) {
                AlertDialog(
                    onDismissRequest = { isFilterDialogOpen = false },
                    icon = {
                        Icon(
                            Icons.Default.Tune,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    title = {
                        Text(
                            "Filtros Avanzados",
                            fontWeight = FontWeight.Bold
                        )
                    },
                    text = {
                        Text(
                            "Aquí puedes filtrar por Partido, Región y Denuncias.\n\nImplementa los controles específicos según tus necesidades.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    confirmButton = {
                        Button(
                            onClick = { isFilterDialogOpen = false }
                        ) {
                            Text("Aplicar")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                isFilterDialogOpen = false
                                currentFilters = FilterState()
                            }
                        ) {
                            Text("Limpiar")
                        }
                    },
                    shape = RoundedCornerShape(24.dp)
                )
            }

            if (candidatosFiltrados.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "🔍",
                        style = MaterialTheme.typography.displayLarge
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        "No se encontraron candidatos",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Intenta con otros términos de búsqueda o ajusta los filtros",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        end = 16.dp,
                        top = 12.dp,
                        bottom = 96.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(candidatosFiltrados) { candidato ->
                        val isSelected = candidatosAComparar.contains(candidato.id)

                        CardCandidato(
                            candidato = candidato,
                            onClick = {
                                if (isCompareMode) {
                                    candidatosAComparar = if (isSelected) {
                                        candidatosAComparar.minus(candidato.id)
                                    } else {
                                        if (candidatosAComparar.size < 3) {
                                            candidatosAComparar.plus(candidato.id)
                                        } else {
                                            candidatosAComparar
                                        }
                                    }
                                } else {
                                    onNavigateToCandidatoDetail(candidato.id)
                                }
                            },
                            isSelected = isSelected,
                            isSelectionMode = isCompareMode
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Candidatos List Preview")
@Composable
fun listcandidatospreview() {
    Project01ATheme {
        CandidatosListScreen(
            onNavigateToCandidatoDetail = {},
            onNavigateToComparacion = {},
            onNavigateBack = {}
        )
    }
}