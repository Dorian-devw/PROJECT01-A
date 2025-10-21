package com.proyecto.project01_a.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import com.proyecto.project01_a.data.repository.DecidePeruRepository
import com.proyecto.project01_a.ui.components.CardCandidato

@Composable
fun CandidatosListScreen(
    onNavigateToCandidatoDetail: (String) -> Unit // Para ver el detalle de un candidato
) {
    // 1. Obtener los datos (se sigue usando el repositorio)
    val candidatos = DecidePeruRepository.getCandidatosPresidenciales()

    Scaffold(
        topBar = { /* TopBar con botón de retroceso */ }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            // 2. Aquí se lista la información
            items(candidatos) { candidato ->
                CardCandidato(
                    candidato = candidato,
                    onClick = { onNavigateToCandidatoDetail(candidato.id) }
                    // ... modificadores
                )
            }
        }
    }
}