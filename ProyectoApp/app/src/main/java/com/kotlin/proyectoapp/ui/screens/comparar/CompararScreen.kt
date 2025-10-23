package com.kotlin.proyectoapp.ui.screens.comparar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kotlin.proyectoapp.R
import com.kotlin.proyectoapp.domain.model.Candidato
import com.kotlin.proyectoapp.ui.components.CandidatoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompararScreen(
    viewModel: CompararViewModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.compare_candidates)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },
                actions = {
                    if (uiState.candidatosSeleccionados.isNotEmpty()) {
                        TextButton(onClick = { viewModel.clearSelection() }) {
                            Text(
                                text = stringResource(R.string.clear_selection),
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Instrucciones
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(
                    text = "${stringResource(R.string.select_candidates)} (${uiState.candidatosSeleccionados.size}/3)",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }

            when {
                uiState.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                uiState.candidatosSeleccionados.size >= 2 -> {
                    // Vista de comparación
                    ComparisonView(
                        candidatos = uiState.candidatosSeleccionados,
                        modifier = Modifier.weight(1f)
                    )
                }

                else -> {
                    // Lista de candidatos para seleccionar
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            items = uiState.candidatosDisponibles,
                            key = { it.id }
                        ) { candidato ->
                            SelectableCandidatoCard(
                                candidato = candidato,
                                isSelected = uiState.candidatosSeleccionados.contains(candidato),
                                onClick = { viewModel.toggleCandidatoSelection(candidato) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SelectableCandidatoCard(
    candidato: Candidato,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 4.dp else 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isSelected,
                onCheckedChange = { onClick() }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = candidato.nombreCompleto,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = candidato.partido,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Seleccionado",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun ComparisonView(
    candidatos: List<Candidato>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Nombres
        item {
            ComparisonRow(
                label = "Nombre",
                values = candidatos.map { it.nombreCompleto }
            )
        }

        // Partido
        item {
            ComparisonRow(
                label = stringResource(R.string.party),
                values = candidatos.map { it.partido }
            )
        }

        // Cargo
        item {
            ComparisonRow(
                label = "Cargo",
                values = candidatos.map { it.cargo }
            )
        }

        // Región
        item {
            ComparisonRow(
                label = stringResource(R.string.region),
                values = candidatos.map { it.region }
            )
        }

        // Profesión
        item {
            ComparisonRow(
                label = stringResource(R.string.profession),
                values = candidatos.map { it.profesion }
            )
        }

        // Proyectos
        item {
            ComparisonRow(
                label = "Proyectos presentados",
                values = candidatos.map { "${it.proyectos.size}" }
            )
        }

        // Denuncias
        item {
            ComparisonRow(
                label = "Denuncias",
                values = candidatos.map { "${it.denuncias.size}" },
                isWarning = true
            )
        }
    }
}

@Composable
fun ComparisonRow(
    label: String,
    values: List<String>,
    isWarning: Boolean = false,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (isWarning)
                MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.1f)
            else
                MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                values.forEach { value ->
                    Text(
                        text = value,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}