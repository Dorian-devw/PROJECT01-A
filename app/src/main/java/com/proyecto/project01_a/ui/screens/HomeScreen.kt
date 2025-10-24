package com.proyecto.project01_a.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.proyecto.project01_a.ui.components.MenuCard
import com.proyecto.project01_a.ui.components.SectionTitle
import com.proyecto.project01_a.ui.theme.Project01ATheme
import kotlinx.coroutines.delay
import com.proyecto.project01_a.ui.components.QuickAccessSection
import com.proyecto.project01_a.ui.components.FeaturedSection
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.platform.LocalFocusManager




val DecidePeruDarkBlue = Color(0xFF0097D0)
val DecidePeruLightBlue = Color(0xFF137FDD)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToCandidatoDetail: (String) -> Unit,
    onNavigateToCandidatosList: () -> Unit,
    onNavigateToPartidos: () -> Unit,
    onNavigateToCongreso: () -> Unit,
    onNavigateToNoticias: () -> Unit,
    onNavigateToEducacion: () -> Unit
) {
    val context = LocalContext.current
    val openUrl: (String) -> Unit = { url ->
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    // Definición del TopAppBar Fijo
    val fixedTopBar = @Composable {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Decide Perú",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = DecidePeruDarkBlue,
                titleContentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
    Scaffold(
        topBar = fixedTopBar,
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                item {
                    HeaderContent(
                        onNavigateToCandidatosList = onNavigateToCandidatosList
                    )
                }
                item {
                    QuickAccessSection(
                        onNavigateToCandidatosList = {
                            onNavigateToCandidatosList()
                        },
                        onNavigateToPartidos = { onNavigateToPartidos() }
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    FeaturedSection(
                        onCandidateClick = onNavigateToCandidatoDetail,
                        onViewFullSourceClick = openUrl
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

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
fun HeaderContent(
    // 1. NUEVO PARÁMETRO: Handler de navegación
    onNavigateToCandidatosList: () -> Unit
) {
    var currentSlide by remember { mutableStateOf(0) }
    val totalSlides = 2
    val slideDuration = 7000L
    // LocalFocusManager no es estrictamente necesario aquí si 'enabled=false',
    // pero lo dejamos por si se necesita para otros fines.
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = Unit) {
        while (true) {
            delay(slideDuration)
            currentSlide = (currentSlide + 1) % totalSlides
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DecidePeruDarkBlue)
    ) {

        // 2. ENVOLVER EN UN BOX Y USAR CLICKABLE (Campo de Búsqueda)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 10.dp)
                // 3. Modificador Clickable que ejecuta la navegación
                .clickable {
                    onNavigateToCandidatosList()
                }
        ) {
            OutlinedTextField(
                // 4. DESHABILITAR LA ESCRITURA DIRECTA
                value = "",
                onValueChange = { /* No hace nada aquí */ },
                enabled = false, // Deshabilita la interacción de escritura/foco
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Buscar candidato....") },
                leadingIcon = {
                    Icon(
                        contentDescription = "Buscar",
                        imageVector = Icons.Default.Search,
                        // Usar Color.Black o un color de tema compatible con el fondo blanco
                        tint = Color.Black
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    disabledContainerColor = Color.White,
                    disabledBorderColor = Color.Transparent,
                    disabledTextColor = Color.Black, // Color para el texto del placeholder
                    disabledPlaceholderColor = Color.Gray // Color para el texto del placeholder
                ),
                shape = RoundedCornerShape(8.dp),
            )
        }


        // Bloque del Slide/Carrusel
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(DecidePeruLightBlue)
                .padding(bottom = 24.dp)
        ) {
            // **CONTENIDO RESTAURADO:** Aquí estaba el código que faltaba
            Column(modifier = Modifier.fillMaxWidth()) {
                SlideContent(currentSlide = currentSlide)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(totalSlides) { index ->
                        val isSelected = index == currentSlide
                        val indicatorWidth = if (isSelected) 24.dp else 8.dp

                        Box(
                            modifier = Modifier
                                .height(8.dp)
                                .width(indicatorWidth)
                                .clip(CircleShape)
                                .background(if (isSelected) Color.White else Color.White.copy(alpha = 0.5f))
                                .clickable { currentSlide = index }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        } // <--- Cierre del Box del Slide/Carrusel
    } // <--- Cierre del Column principal
}
@Composable
fun SlideContent(currentSlide: Int) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
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
        Image(
            painter = painterResource(
                id = when (currentSlide) {
                    0 -> R.drawable.votaciones
                    else -> R.drawable.votoinformado
                }
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
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