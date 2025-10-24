package com.kotlin.proyectoapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.kotlin.proyectoapp.domain.model.Candidato

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CandidatoCard(
    candidato: Candidato,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // esto es la foto del candidato con glide
            Surface(
                modifier = Modifier
                    .size(80.dp)
                    .clip(MaterialTheme.shapes.medium),
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                GlideImage(
                    model = candidato.fotoUrl,
                    contentDescription = "Foto de ${candidato.nombreCompleto}",
                    contentScale = ContentScale.Crop,
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // info del candidato
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = candidato.nombreCompleto,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = candidato.partido,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AssistChip(
                        onClick = { },
                        label = {
                            Text(
                                text = candidato.cargo,
                                style = MaterialTheme.typography.labelSmall
                            )
                        },
                        enabled = false
                    )

                    AssistChip(
                        onClick = { },
                        label = {
                            Text(
                                text = candidato.region,
                                style = MaterialTheme.typography.labelSmall
                            )
                        },
                        enabled = false
                    )
                }
            }
        }
    }
}