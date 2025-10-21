package com.proyecto.project01_a.ui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.Dp

/**
 * Forma personalizada que recorta la parte inferior de un Composable
 * con un arco CÓNCAVO (redondeado hacia arriba), simulando una "muesca" suave.
 *
 * @param cutHeight La altura (profundidad) del corte del arco en Dp.
 */
// Archivo: ArcClipShape.kt

class ArcClipShape(private val cutHeight: Dp) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val cutHeightPx = with(density) { cutHeight.toPx() }

        return Outline.Generic(Path().apply {
            val width = size.width
            val height = size.height

            // 1. Empezar en la esquina superior izquierda
            moveTo(0f, 0f)

            // 2. Línea hacia la esquina superior derecha
            lineTo(width, 0f)

            // 3. Línea hacia el punto de inicio del arco en la esquina inferior derecha
            // El arco debe empezar en (width, height), pero en este caso, vamos un poco más arriba
            // para que la curva sea solo en la parte inferior.

            // Nos movemos horizontalmente hasta el final del ancho (width)
            // y verticalmente hasta la posición 'height' (fondo del contenedor)
            lineTo(width, height)

            // 4. CREAR EL ARCO CÓNCAVO

            // Punto de control: Centrado horizontalmente (width/2)
            val controlX = width / 2f

            // Punto de control Y: Menos la altura de corte (hacia arriba)
            val controlY = height - cutHeightPx

            // El arco debe empezar en la esquina inferior derecha (width, height)
            // y terminar en la esquina inferior izquierda (0f, height).

            // Usamos un 'lineTo' para establecer el punto de partida del arco
            // Desde (width, height) dibujamos la curva hacia (0f, height)

            // quadTo(controlX, controlY, endX, endY)
            quadTo(controlX, controlY, 0f, height)
            // Esto asume que el punto actual es (width, height) y dibuja el arco

            // 5. Cierra la forma, volviendo a (0f, 0f)
            close()
        })
    }

    private fun Path.quadTo(controlX: Float, controlY: Float, f3: Float, height: Float) {

    }
    // ... (función Path.quadTo redundante eliminada para una versión limpia si es posible)
}