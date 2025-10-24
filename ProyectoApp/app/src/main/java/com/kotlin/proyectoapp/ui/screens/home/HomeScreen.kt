package com.kotlin.proyectoapp.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Compare
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kotlin.proyectoapp.R
import com.kotlin.proyectoapp.ui.components.CandidatoCard
import com.kotlin.proyectoapp.ui.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onCandidatoClick: (Int) -> Unit,
    onCompararClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EligePeru") },
                actions = {
                    IconButton(onClick = onCompararClick) {
                        Icon(
                            imageVector = Icons.Default.Compare,
                            contentDescription = stringResource(R.string.compare_candidates)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Barra de búsqueda
            SearchBar(
                query = searchQuery,
                onQueryChange = { query ->
                    searchQuery = query
                    viewModel.searchCandidatos(query)
                },
                modifier = Modifier.padding(16.dp)
            )

            // Filtros
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = uiState.filterCargo == "Todos",
                    onClick = { viewModel.filterByCargo("Todos") },
                    label = { Text(stringResource(R.string.filter_all)) }
                )
                FilterChip(
                    selected = uiState.filterCargo == "Presidencia",
                    onClick = { viewModel.filterByCargo("Presidencia") },
                    label = { Text(stringResource(R.string.filter_presidencia)) }
                )
                FilterChip(
                    selected = uiState.filterCargo == "Congreso",
                    onClick = { viewModel.filterByCargo("Congreso") },
                    label = { Text(stringResource(R.string.filter_congreso)) }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Lista de candidatos
            when {
                uiState.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                uiState.error != null -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = uiState.error ?: "",
                                color = MaterialTheme.colorScheme.error
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = { viewModel.loadCandidatos() }) {
                                Text(stringResource(R.string.retry))
                            }
                        }
                    }
                }

                uiState.candidatos.isEmpty() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No se encontraron candidatos")
                    }
                }

                else -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            items = uiState.candidatos,
                            key = { it.id }
                        ) { candidato ->
                            CandidatoCard(
                                candidato = candidato,
                                onClick = { onCandidatoClick(candidato.id) }
                            )
                        }
                    }
                }
            }
        }
    }
}