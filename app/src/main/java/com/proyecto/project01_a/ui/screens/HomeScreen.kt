package com.proyecto.project01_a.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.data.repository.DecidePeruRepository
import com.proyecto.project01_a.ui.components.CardCandidato
import com.proyecto.project01_a.ui.components.MenuCard
import com.proyecto.project01_a.ui.components.SectionTitle
import com.proyecto.project01_a.ui.theme.PeruRed
import com.proyecto.project01_a.ui.theme.PeruWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToCandidato: (String) -> Unit,
    onNavigateToCongreso: () -> Unit,
    onNavigateToNoticias: () -> Unit,
    onNavigateToEducacion: () -> Unit
) {
    val candidatos = DecidePeruRepository.getCandidatosPresidenciales()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.HowToVote,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "DecidePerú",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "🇵🇪",
                            style = MaterialTheme.typography.displayLarge
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Elecciones Generales 2026",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Infórmate sobre los candidatos y toma una decisión consciente para el futuro del Perú",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                SectionTitle(
                    title = "Candidatos Presidenciales",
                    icon = Icons.Default.Person
                )
            }

            items(candidatos) { candidato ->
                CardCandidato(
                    candidato = candidato,
                    onClick = { onNavigateToCandidato(candidato.id) }
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                SectionTitle(
                    title = "Más Información",
                    icon = Icons.Default.Dashboard
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                MenuCard(
                    title = "Candidatos al Congreso",
                    description = "Conoce a los candidatos para el Poder Legislativo",
                    icon = Icons.Default.Groups,
                    onClick = onNavigateToCongreso
                )
            }

            item {
                MenuCard(
                    title = "Noticias Políticas",
                    description = "Últimas noticias sobre las elecciones 2026",
                    icon = Icons.Default.Newspaper,
                    onClick = onNavigateToNoticias
                )
            }

            item {
                MenuCard(
                    title = "Educación Cívica",
                    description = "Aprende sobre el sistema político peruano",
                    icon = Icons.Default.School,
                    onClick = onNavigateToEducacion
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Toda la información presentada es de carácter público y verificable",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}