package com.proyecto.project01_a.ui.screens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.proyecto.project01_a.data.model.*
import com.proyecto.project01_a.data.repository.DecidePeruRepository
import com.proyecto.project01_a.ui.components.TopBar
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.material.icons.filled.Link
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
@Composable
fun CandidatoDetailScreen(
    candidatoId: String,
    onNavigateBack: () -> Unit,
    onNavigateToPartido: (String) -> Unit
) {
    val candidato = DecidePeruRepository.getCandidatoById(candidatoId)
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Propuestas", "Historial", "Denuncias", "Financiamiento")

    if (candidato == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Candidato no encontrado")
        }
        return
    }

    Scaffold(
        topBar = {
            TopBar(
                title = candidato.nombre,
                onNavigateBack = onNavigateBack
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                CandidatoHeader(candidato = candidato, onNavigateToPartido = onNavigateToPartido)
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Biografía",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = candidato.biografia,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            item {
                ScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    modifier = Modifier.fillMaxWidth(),
                    edgePadding = 16.dp
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = {
                                Text(
                                    text = title,
                                    fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            when (selectedTab) {
                0 -> {
                    items(candidato.propuestas) { propuesta ->
                        PropuestaCard(propuesta)
                    }
                }
                1 -> {
                    items(candidato.historial) { cargo ->
                        HistorialCard(cargo)
                    }
                }
                2 -> {
                    if (candidato.denuncias.isEmpty()) {
                        item {
                            EmptyStateCard("No hay denuncias registradas")
                        }
                    } else {
                        items(candidato.denuncias) { denuncia ->
                            DenunciaCard(denuncia)
                        }
                    }
                }
                3 -> {
                    item {
                        FinanciamientoCard(candidato.financiamiento)
                    }
                }
            }

        }
    }
}

// --- Nuevo Componente de Cabecera (Header) ---
// --- Nuevo Componente de Cabecera (Header) ---
@Composable
fun CandidatoHeader(
    candidato: Candidato,
    onNavigateToPartido: (String) -> Unit
) {
    // Usamos rememberLauncherForActivityResult para manejar la apertura de URLs
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current // Mejor práctica para abrir URLs en Compose
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp) // Mantenemos 350dp para un buen espacio
            .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
    ) {
        // 1. Imagen de Fondo
        AsyncImage(
            model = candidato.fotoUrl,
            contentDescription = candidato.nombre,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // 2. Overlay de Sombra Suave (paleta de colores ajustada para un contraste más suave)
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Black.copy(alpha = 0.35f)) // Ligeramente menos opaco para ser más "ligero"
        )

        // 3. Contenido Superpuesto (Nombre, Partido, Chips)
        Column(
            // **CAMBIO CLAVE 1: Alineamos al centro y añadimos padding superior**
            // Usamos Alignment.TopCenter y un espaciador o padding para empujar el contenido.
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center) // Alineamos al centro de la Box, luego usamos padding para ajustarlo
                .padding(horizontal = 24.dp), // Padding a los lados
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // **CAMBIO CLAVE 2: Espaciador superior para empujar el contenido hacia abajo (posición 40)**
            // 350dp * 40% = 140dp. Usaremos un Spacer que lo empuje a esa posición.
            Spacer(modifier = Modifier.height(150.dp)) // Espaciador para empezar el contenido más arriba que el centro.

            // Nombre
            Text(
                text = candidato.nombre,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp)) // Aumentado para mejor separación visual

            // Partido (Botón/Chip de navegación)
            Surface(
                shape = RoundedCornerShape(20.dp),
                // **AJUSTE DE COLOR: Usamos el color principal para coherencia**
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { onNavigateToPartido(candidato.partido) }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = candidato.partido,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Medium
                    )
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp)) // Aumentado el espacio antes de los chips

            // Chips de Edad y Profesión
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Chip Edad
                InfoChip(
                    label = "Edad",
                    value = "${candidato.edad} años",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                // Chip Profesión
                InfoChip(
                    label = "Profesión",
                    value = candidato.profesion,
                    modifier = Modifier.weight(1.5f),
                    textAlign = TextAlign.Center
                )
            }

            // Espaciador para empujar el contenido arriba si no está centrado
            Spacer(modifier = Modifier.height(30.dp))
        }
        // ** 4. NUEVA ADICIÓN: Botón de Fuente (Alineado en la esquina inferior izquierda) **
        // Usamos Surface para el estilo de chip y lo alineamos a BottomStart
        Surface(
            shape = RoundedCornerShape(bottomEnd = 10.dp), // Solo borde redondeado en la parte superior derecha
            color = Color.White.copy(alpha = 0.8f), // Fondo semi-transparente para contrastar
            modifier = Modifier
                .align(Alignment.TopEnd) // ALINEACIÓN CLAVE: Inferior Izquierda
                .clickable { uriHandler.openUri(candidato.fuenteUrl) }
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Link, // Ícono de enlace o fuente
                    contentDescription = "Fuente",
                    tint = MaterialTheme.colorScheme.primary, // Color del tema para destacar
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Ver Fuente",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        // ********************************************************************************

    }
}

// --- Componente InfoChip (Definición Asumida y Mejorada para aceptar TextAlign) ---
// --- Componente InfoChip (Definición Asumida y Mejorada para aceptar TextAlign) ---
@Composable
fun InfoChip(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null // Nuevo parámetro opcional para alineación del valor
) {
    Card(
        // **CAMBIO CLAVE 3: Corregimos la altura mínima para evitar recortes.**
        modifier = modifier.heightIn(min = 5.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            // **AJUSTE DE COLOR: Usamos primary/secondary con baja opacidad para coherencia.**
            containerColor = Color.Black.copy(alpha = 0.7f) // Fondo de chip más coherente
        ),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                // **AJUSTE DE COLOR: Texto secundario para el label, pero legible**
                color = Color.White.copy(alpha = 0.8f),
                fontWeight = FontWeight.Normal
            )
            Text(
                text = value,
                style = MaterialTheme.typography.titleSmall,
                // **AJUSTE DE COLOR: Texto principal (blanco) para el valor**
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                textAlign = textAlign
            )
        }
    }
}

@Composable
fun PropuestaCard(propuesta: Propuesta) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    Text(
                        text = propuesta.categoria,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontWeight = FontWeight.Medium
                    )
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = when (propuesta.prioridad) {
                        "Alta" -> MaterialTheme.colorScheme.error.copy(alpha = 0.1f)
                        "Media" -> MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                        else -> MaterialTheme.colorScheme.surfaceVariant
                    }
                ) {
                    Text(
                        text = "Prioridad ${propuesta.prioridad}",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        color = when (propuesta.prioridad) {
                            "Alta" -> MaterialTheme.colorScheme.error
                            "Media" -> MaterialTheme.colorScheme.primary
                            else -> MaterialTheme.colorScheme.onSurfaceVariant
                        },
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = propuesta.titulo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = propuesta.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun HistorialCard(cargo: CargoAnterior) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        MaterialTheme.colorScheme.primaryContainer,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Work,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = cargo.cargo,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = cargo.institucion,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = cargo.periodo,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = cargo.descripcion,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun DenunciaCard(denuncia: Denuncia) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = denuncia.tipo,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.error
                    )
                }

                Text(
                    text = denuncia.año.toString(),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = denuncia.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(12.dp))

            Surface(
                shape = RoundedCornerShape(6.dp),
                color = when (denuncia.estado) {
                    "Archivado" -> MaterialTheme.colorScheme.surfaceVariant
                    "En proceso" -> MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                    "Sentenciado" -> MaterialTheme.colorScheme.error.copy(alpha = 0.2f)
                    else -> MaterialTheme.colorScheme.surfaceVariant
                }
            ) {
                Text(
                    text = "Estado: ${denuncia.estado}",
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun FinanciamientoCard(financiamiento: Financiamiento) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Monto Declarado",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = financiamiento.montoDeclared,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Fuentes Principales",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(12.dp))

            financiamiento.fuentesPrincipales.forEach { fuente ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = fuente,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Divider()

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Transparencia",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = when (financiamiento.transparencia) {
                        "Alta" -> MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                        "Media" -> MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                        else -> MaterialTheme.colorScheme.surfaceVariant
                    }
                ) {
                    Text(
                        text = financiamiento.transparencia,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}


@Composable
fun SocialMediaButton(name: String, icon: ImageVector) {
    OutlinedButton(
        onClick = { /* Open URL */ },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = name,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = name,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )
        Icon(
            imageVector = Icons.Default.OpenInNew,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
fun EmptyStateCard(message: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
