/*package com.proyecto.project01_a.ui.components

// Importaciones necesarias
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.ui.screens.FilterState // Importa la Data Class

/**
 * Diálogo de Filtros Avanzados.
 * Solo maneja filtros que no se gestionan fácilmente con chips en la pantalla principal,
 * como la opción booleana "Mostrar solo con Denuncias".
 * * Los parámetros availablePartidos y availableRegiones se han eliminado, ya que no se usan aquí.
 */
@Composable
fun FilterDialog(
    currentFilters: FilterState,
    onDismiss: () -> Unit,
    onApplyFilters: (FilterState) -> Unit,
    onClearFilters: () -> Unit
    // Se eliminan: availablePartidos: List<String>, availableRegiones: List<String>
) {
    // 1. Estado temporal local para la UI del diálogo (solo Denuncias)
    var showDenuncias by remember { mutableStateOf(currentFilters.hasDenuncias) }

    // Al ser un diálogo avanzado, mantenemos los filtros de Región y Partido
    // en su estado actual (los que se seleccionaron en los Chips) para aplicarlos junto a Denuncias.
    val selectedPartido = currentFilters.partido
    val selectedRegion = currentFilters.region

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Filtros Avanzados") },
        text = {
            Column(modifier = Modifier.padding(top = 8.dp)) {

                // Filtros Activos (solo visualización, ya que se gestionan con los Chips)
                Text(
                    text = "Partido seleccionado: ${selectedPartido ?: "Todos"}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Departamento seleccionado: ${selectedRegion ?: "Todos"}",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(16.dp))

                Divider()

                Spacer(modifier = Modifier.height(16.dp))

                // A. FILTRO POR DENUNCIAS (Único filtro avanzado editable aquí)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Mostrar solo con denuncias", style = MaterialTheme.typography.bodyLarge)
                    Switch(
                        checked = showDenuncias,
                        onCheckedChange = { showDenuncias = it }
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    // Aplicamos el nuevo estado de Denuncias, pero conservamos Partido y Región
                    onApplyFilters(
                        FilterState(
                            partido = selectedPartido,
                            region = selectedRegion,
                            hasDenuncias = showDenuncias // Nuevo estado
                        )
                    )
                }
            ) {
                Text("Aplicar Filtros")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    // Al "Limpiar", reseteamos la Denuncia y pedimos a la pantalla principal
                    // que borre el resto de filtros (Partido y Región)
                    onClearFilters()
                }
            ) {
                Text("Limpiar Todo")
            }
        }
    )
}

// Se elimina el componente FilterDropdown ya que no es necesario aquí.
*/