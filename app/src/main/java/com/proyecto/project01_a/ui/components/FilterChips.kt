/*package com.proyecto.project01_a.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.ui.screens.FilterState

// *****************************************************************
// 1. CHIP DE FILTRO AVANZADO (Filtros, Denuncias)
// *****************************************************************

@Composable
fun AdvancedFilterChip(currentFilters: FilterState, onClick: () -> Unit) {
    val activeCount = if (currentFilters.hasDenuncias) 1 else 0
    val isActive = activeCount > 0
    val labelText = if (isActive) "Filtros ($activeCount)" else "Filtros"

    FilterChip(
        selected = isActive,
        onClick = onClick,
        label = { Text(labelText) },
        leadingIcon = { Icon(Icons.Default.Tune, contentDescription = "Filtro Avanzado") },
        colors = FilterChipDefaults.filterChipColors(
            // UNSELECTED STATE
            containerColor = Color.White,
            labelColor = Color.Black,
            leadingIconColor = Color.Black,
            // SELECTED STATE
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = Color.White,
            selectedLeadingIconColor = Color.White,
            // DESACTIVADO (Solución al error de compilación)
            disabledContainerColor = Color.LightGray,
            disabledLabelColor = Color.Gray,
            disabledLeadingIconColor = Color.Gray
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
            selectedBorderColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.height(36.dp)
    )
}

// *****************************************************************
// 2. CHIP DE FILTRO DROPDOWN (Departamento, Partido)
// *****************************************************************

@Composable
fun DropdownFilterChip(
    label: String,
    selectedValue: String,
    options: List<String>,
    onSelect: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val isFilterActive = selectedValue != "Todos"

    FilterChip(
        selected = isFilterActive,
        onClick = { expanded = true },
        label = { Text("$label: $selectedValue") },
        trailingIcon = { Icon(Icons.Default.ArrowDropDown, contentDescription = null) },
        colors = FilterChipDefaults.filterChipColors(
            // UNSELECTED STATE
            containerColor = Color.White,
            labelColor = Color.Black,
            trailingIconColor = Color.Black,
            // SELECTED STATE
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = Color.White,
            selectedTrailingIconColor = Color.White,
            // DESACTIVADO (Solución al error de compilación)
            disabledContainerColor = Color.LightGray,
            disabledLabelColor = Color.Gray,
            disabledTrailingIconColor = Color.Gray
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
            selectedBorderColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.height(36.dp)
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        options.forEach { option ->
            DropdownMenuItem(
                text = { Text(option) },
                onClick = {
                    onSelect(option)
                    expanded = false
                },
                colors = MenuDefaults.dropdownMenuItemColors(
                    textColor = if (option == selectedValue) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
            )
        }
    }
}*/
