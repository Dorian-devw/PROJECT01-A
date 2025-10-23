package com.proyecto.project01_a.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.data.repository.DecidePeruRepository
import com.proyecto.project01_a.ui.components.CardCandidato
import com.proyecto.project01_a.data.model.Candidato
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.proyecto.project01_a.ui.theme.Project01ATheme
import java.text.Normalizer // <-- Importación necesaria

// *****************************************************************
// 1. FUNCIÓN DE UTILIDAD PARA NORMALIZAR Y ELIMINAR TILDES
// *****************************************************************

fun String.normalizeAndLowercase(): String {
    val normalized = Normalizer.normalize(this, Normalizer.Form.NFD)
    return normalized.replace("[\\p{Mn}]".toRegex(), "").lowercase()
}

// *****************************************************************
// 2. CANDIDATOS LIST SCREEN (MEJORADA)
// *****************************************************************

// Definimos los estados de filtro que usaremos más adelante
data class FilterState(
    val partido: String? = null,
    val region: String? = null,
    val hasDenuncias: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CandidatosListScreen(
    onNavigateToCandidatoDetail: (String) -> Unit
) {
    // Estado del texto de búsqueda
    var searchText by remember { mutableStateOf("") }

    // Estado de los filtros avanzados (usado para la RF21 - Implementación futura)
    var isFilterDialogOpen by remember { mutableStateOf(false) }
    var currentFilters by remember { mutableStateOf(FilterState()) }

    // Lista completa de candidatos (asumiendo que tiene el campo 'region')
    val todosLosCandidatos = remember { DecidePeruRepository.getCandidatosPresidenciales() }

    // Lógica de Filtrado COMPLEJA: Aplica búsqueda de texto Y filtros avanzados
    val candidatosFiltrados = remember(searchText, currentFilters) {
        todosLosCandidatos.filter { candidato ->
            // A. Aplicar Búsqueda de Texto (ahora insensible a tildes)
            val queryNormalized = searchText.normalizeAndLowercase()
            val textMatch = if (queryNormalized.isBlank()) {
                true // No hay búsqueda de texto, pasa
            } else {
                candidato.nombre.normalizeAndLowercase().contains(queryNormalized) ||
                        candidato.partido.normalizeAndLowercase().contains(queryNormalized) ||
                        candidato.region.normalizeAndLowercase().contains(queryNormalized)
            }

            // B. Aplicar Filtros Avanzados (si están activos)
            val filterMatch = when {
                // Filtro por Denuncias
                currentFilters.hasDenuncias && candidato.denuncias.isEmpty() -> false

                // Filtro por Partido (Comparación estricta, si está seleccionado)
                currentFilters.partido != null && currentFilters.partido != candidato.partido -> false

                // Filtro por Región (Comparación estricta, si está seleccionado)
                currentFilters.region != null && currentFilters.region != candidato.region -> false

                else -> true // Pasa si ningún filtro lo detiene
            }

            // Un candidato aparece si cumple ambas condiciones
            textMatch && filterMatch
        }
    }

    Scaffold(
        topBar = { /* TopBar con botón de retroceso */ }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // --- BARRA DE BÚSQUEDA Y FILTRADO (Diseño Limpio y Profesional) ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 1. CAMPO DE BÚSQUEDA (Search Bar)
                // Usamos un TextField regular con Filled style para un look más moderno y limpio en la AppBar
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text("Buscar por nombre, partido o región") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedTextColor = MaterialTheme.colorScheme.onSurface,
                        unfocusedTextColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // 2. BOTÓN DE FILTRO
                FilledTonalIconButton( // Nuevo estilo de botón, limpio pero visible
                    onClick = { isFilterDialogOpen = true },
                    modifier = Modifier.size(56.dp)
                ) {
                    Icon(
                        Icons.Default.Tune,
                        contentDescription = "Opciones de Filtro",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // *****************************************************************
            // 3. DIÁLOGO DE FILTROS AVANZADOS (Preparado para el RF21)
            // *****************************************************************
            if (isFilterDialogOpen) {
                // Aquí iría el componente de diálogo de filtros
                // Por ahora, solo cerraremos al hacer clic afuera
                AlertDialog(
                    onDismissRequest = { isFilterDialogOpen = false },
                    title = { Text("Filtros Avanzados") },
                    text = { Text("Aquí se implementarían opciones para filtrar por Partido, Región y si tiene Denuncias.") },
                    confirmButton = {
                        Button(onClick = { isFilterDialogOpen = false /* Aplicar filtros */ }) {
                            Text("Aceptar")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { isFilterDialogOpen = false; currentFilters = FilterState() /* Limpiar Filtros */ }) {
                            Text("Limpiar")
                        }
                    }
                )
            }


            // --- LISTA DE CANDIDATOS (Filtrada) ---
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(candidatosFiltrados) { candidato ->
                    CardCandidato(
                        candidato = candidato,
                        onClick = { onNavigateToCandidatoDetail(candidato.id) },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true, name = "Home Screen Preview")
@Composable
fun listcandidatospreview() {
    Project01ATheme {
        CandidatosListScreen(onNavigateToCandidatoDetail = {})

    }
}