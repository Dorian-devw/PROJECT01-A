package com.kotlin.proyectoapp.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kotlin.proyectoapp.R
import com.kotlin.proyectoapp.domain.model.Denuncia
import com.kotlin.proyectoapp.ui.theme.DenunciaCivil
import com.kotlin.proyectoapp.ui.theme.DenunciaElectoral
import com.kotlin.proyectoapp.ui.theme.DenunciaPenal

@Composable
fun DenunciaItem(
    denuncia: Denuncia,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.1f)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = getTipoDenunciaColor(denuncia.tipo),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = denuncia.tipo,
                        style = MaterialTheme.typography.titleSmall,
                        color = getTipoDenunciaColor(denuncia.tipo)
                    )
                }

                StatusChip(estado = denuncia.estado)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = denuncia.descripcion,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = denuncia.fecha,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                TextButton(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(denuncia.urlFuente))
                        context.startActivity(intent)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.OpenInNew,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(stringResource(R.string.view_source))
                }
            }
        }
    }
}

@Composable
private fun getTipoDenunciaColor(tipo: String) = when (tipo) {
    "Penal" -> DenunciaPenal
    "Civil" -> DenunciaCivil
    "Electoral" -> DenunciaElectoral
    else -> MaterialTheme.colorScheme.error
}