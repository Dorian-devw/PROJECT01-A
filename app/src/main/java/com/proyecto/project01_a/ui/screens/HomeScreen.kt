package com.proyecto.project01_a.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.proyecto.project01_a.R
import com.proyecto.project01_a.data.repository.DecidePeruRepository
import com.proyecto.project01_a.ui.components.CardCandidato
import com.proyecto.project01_a.ui.components.MenuCard
import com.proyecto.project01_a.ui.components.SectionTitle
import com.proyecto.project01_a.ui.theme.Project01ATheme
import kotlinx.coroutines.delay
import com.proyecto.project01_a.ui.components.QuickAccessSection



import kotlinx.coroutines.launch
// Colores personalizados según el requerimiento
val DecidePeruDarkBlue = Color(0xFF0097D0)
val DecidePeruLightBlue = Color(0xFF137FDD)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToCandidatoDetail: (String) -> Unit,
    onNavigateToCandidatosList: () -> Unit,
    onNavigateToPartidos: () -> Unit,// <<-- NUEVA FUNCIÓN
    onNavigateToCongreso: () -> Unit,
    onNavigateToNoticias: () -> Unit,
    onNavigateToEducacion: () -> Unit
) {

    // El Scaffold ya no tiene un TopAppBar, el "header" es parte del contenido
    Scaffold(
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), // Se aplica el padding del Scaffold
            ) {
                // --- INICIO DEL HEADER PERSONALIZADO ---
                item {
                    HeaderContent()
                }
                // --- FIN DEL HEADER PERSONALIZADO ---

                // --- NUEVA SECCIÓN DE ACCESO RÁPIDO ---
                item {
                    QuickAccessSection(
                        onNavigateToCandidatosList = {
                            onNavigateToCandidatosList() // Llama a la navegación a la LISTA
                        },
                        onNavigateToPartidos = { onNavigateToPartidos() }
                    )
                }
                // --- FIN NUEVA SECCIÓN ---

                /*item {
                    Spacer(modifier = Modifier.height(16.dp))
                    SectionTitle(
                        title = "Candidatos Presidenciales",
                        icon = Icons.Default.Person,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }*/


                /*items(candidatos) { candidato ->
                    CardCandidato(
                        candidato = candidato,
                        onClick = { onNavigateToCandidato(candidato.id) },
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }*/

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    SectionTitle(
                        title = "Más Información",
                        icon = Icons.Default.Dashboard,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {
                    MenuCard(
                        title = "Candidatos al Congreso",
                        description = "Conoce a los candidatos para el Poder Legislativo",
                        icon = Icons.Default.Groups,
                        onClick = onNavigateToCongreso,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                item {
                    MenuCard(
                        title = "Noticias Políticas",
                        description = "Últimas noticias sobre las elecciones 2026",
                        icon = Icons.Default.Newspaper,
                        onClick = onNavigateToNoticias,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                item {
                    MenuCard(
                        title = "Educación Cívica",
                        description = "Aprende sobre el sistema político peruano",
                        icon = Icons.Default.School,
                        onClick = onNavigateToEducacion,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
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
                    Spacer(modifier = Modifier.height(16.dp)) // Padding final
                }
            }
        }
    )
}

@Composable
fun HeaderContent() {
    // Estado para el slide actual (0 o 1)
    var currentSlide by remember { mutableStateOf(0) }
    val totalSlides = 2
    val slideDuration = 3000L // Duración de cada slide en milisegundos

    LaunchedEffect(key1 = Unit)
    {
        while (true){
        delay(slideDuration)
        currentSlide = (currentSlide + 1) % totalSlides
    }
    }
    // Contenedor principal del header: Decide Perú + Barra de Búsqueda
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DecidePeruDarkBlue) // Color #0097D0
            .background(DecidePeruDarkBlue) // Color #0097D0
    ) {
        // 1. Título "Decide Peru" (centrado)
        Text(
            text = "Decide Perú",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 2. Barra de Búsqueda
        OutlinedTextField(
            value = "", // Valor del input
            onValueChange = { /* Manejar el cambio */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 10.dp), // Separación con el siguiente contenedor
            placeholder = { Text("Buscar candidato....") },
            leadingIcon = {
                Icon(
                    contentDescription = "Buscar" ,
                    imageVector = Icons.Default.Search,
                    tint = Color.Black
                    )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp)
        )

        // 3. Contenedor del Slide (con forma entrecortada simulada)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                // Clip para simular el diseño "entrecortado"
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(DecidePeruLightBlue) // Color #137FDD
                .padding(bottom = 24.dp) // Espacio para los indicadores
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                // Contenido del Slide
                SlideContent(currentSlide = currentSlide)

                // Indicadores de Posición (Círculos)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(totalSlides) { index ->
                        // Lógica de "círculo más ancho"
                        val isSelected = index == currentSlide
                        val indicatorWidth = if (isSelected) 24.dp else 8.dp

                        Box(
                            modifier = Modifier
                                .height(8.dp)
                                .width(indicatorWidth)
                                .clip(CircleShape)
                                .background(if (isSelected) Color.White else Color.White.copy(alpha = 0.5f))
                                .clickable { currentSlide = index } // Permitir cambio al tocar
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun SlideContent(currentSlide: Int) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Columna de Texto
        Column(
            modifier = Modifier.weight(1f)
        ) {
            when (currentSlide) {
                0 -> {
                    Text(
                        text = "Elecciones generales 2026",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Infórmate sobre los candidatos y toma una decisión consciente para el futuro de nuestro País",
                        color = Color.White.copy(alpha = 0.8f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                1 -> {
                    // Contenido inventado
                    Text(
                        text = "Impacto del Voto Informado",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Tu decisión tiene el poder de moldear las políticas públicas. Analiza propuestas, no promesas.",
                        color = Color.White.copy(alpha = 0.8f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Imagen (res.drawable)
        Image(
            // **IMPORTANTE**: Debes tener las imágenes en tu carpeta res/drawable con estos nombres
            painter = painterResource(
                id = when (currentSlide) {
                    0 -> R.drawable.votaciones // Usar el nombre que mencionaste
                    else -> R.drawable.votaciones // Usé la misma imagen para el ejemplo
                }
            ),
            contentDescription = null, // Accesibilidad: Ajustar si es necesario
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp) // Tamaño de la imagen
                .clip(RoundedCornerShape(50.dp))
        )
    }
}


@Preview(showBackground = true, name = "Home Screen Preview")
@Composable
fun HomePreview() {
    Project01ATheme {
        HomeScreen(
            onNavigateToCandidatosList = { /* No-op para Preview */ },
            onNavigateToCongreso = { /* No-op para Preview */ },
            onNavigateToCandidatoDetail = { /* No-op para Preview */ },
            onNavigateToNoticias = { /* No-op para Preview */ },
            onNavigateToEducacion = { /* No-op para Preview */ },
            onNavigateToPartidos = { /* No-op para Preview */ }
        )
    }
}