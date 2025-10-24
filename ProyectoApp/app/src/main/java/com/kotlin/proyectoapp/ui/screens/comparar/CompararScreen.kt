package com.kotlin.proyectoapp.ui.screens.comparar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.kotlin.proyectoapp.R
import com.kotlin.proyectoapp.domain.model.Candidato

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
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },
                actions = {
                    if (uiState.candidatosSeleccionados.isNotEmpty()) {
                        TextButton(onClick = { viewModel.clearSelection() }) {
                            Text(
                                text = stringResource(R.string.clear_selection)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
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
            if (uiState.candidatosSeleccionados.size < 2) {
                // Vista de selección
                Column {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Text(
                            text = "${stringResource(R.string.select_candidates_to_compare)} (${uiState.candidatosSeleccionados.size}/2)",
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
                        else -> {
                            LazyColumn(
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
            } else {
                // Vista de comparación
                ComparisonView(
                    candidatos = uiState.candidatosSeleccionados,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SelectableCandidatoCard(
    candidato: Candidato,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 8.dp else 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                model = candidato.fotoUrl,
                contentDescription = "Foto de ${candidato.nombreCompleto}",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            ){
                it.placeholder(R.drawable.ic_person)
                 .error(R.drawable.ic_person)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = candidato.nombreCompleto,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
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
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
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
    val party = stringResource(R.string.party)
    val region = stringResource(R.string.region)
    val profession = stringResource(R.string.profession)

    Column(modifier = modifier.fillMaxSize()) {
        // Cabeceras con Nombres y Fotos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Celda vacía para la etiqueta de la fila
            Spacer(modifier = Modifier.weight(0.5f))
            candidatos.forEach { candidato ->
                ComparisonHeader(candidato = candidato, modifier = Modifier.weight(1f))
            }
        }

        HorizontalDivider()

        // Contenido de la comparación en una LazyColumn para scroll vertical
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            val comparisonItems = listOf(
                party to candidatos.map { it.partido },
                "Cargo" to candidatos.map { it.cargo },
                region to candidatos.map { it.region },
                profession to candidatos.map { it.profesion },
                "Proyectos" to candidatos.map { "${it.proyectos.size}" },
                "Denuncias" to candidatos.map { "${it.denuncias.size}" }
            )

            items(comparisonItems) { (label, values) ->
                ComparisonRow(
                    label = label,
                    values = values,
                    isWarning = label == "Denuncias"
                )
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ComparisonHeader(candidato: Candidato, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        GlideImage(
            model = candidato.fotoUrl,
            contentDescription = "Foto de ${candidato.nombreCompleto}",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        ){
             it.placeholder(R.drawable.ic_person)
              .error(R.drawable.ic_person)
        }
        Text(
            text = candidato.nombreCompleto,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ComparisonRow(
    label: String,
    values: List<String>,
    isWarning: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Etiqueta de la Fila
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.weight(0.5f)
        )

        // Valores para cada candidato
        values.forEach { value ->
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = if (isWarning && value != "0") MaterialTheme.colorScheme.error else LocalContentColor.current,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}