package com.proyecto.project01_a.ui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

/**
 * Forma personalizada que recorta la parte inferior de un Composable
 * con un arco cóncavo (redondeado hacia abajo), simulando una "muesca" suave.
 *
 * @param arcDepthRatio La profundidad del arco como proporción de la altura total. (ej. 0.1f)
 */
class BottomArcShape(private val arcDepthRatio: Float) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(Path().apply {
            val width = size.width
            val height = size.height
            val arcDepth = height * arcDepthRatio

            // 1. Empezar en la esquina superior izquierda
            moveTo(0f, 0f)

            // 2. Línea hacia la esquina superior derecha
            lineTo(width, 0f)

            // 3. Línea hacia la esquina inferior derecha
            lineTo(width, height)

            // 4. Crear el arco cóncavo inferior (curva de Bezier)
            // Punto de control: centro del ancho, debajo de la altura
            val controlX = width / 2f
            val controlY = height + arcDepth // Va más allá del contenedor

            // Conectar la esquina inferior derecha a la izquierda usando una curva suave
            // Usamos un punto de control centralizado y profundo para la curva
            quadTo(controlX, controlY, 0f, height)

            // 5. Cierra la forma, volviendo a (0f, 0f)
            close()
        })
    }

    private fun Path.quadTo(controlX: Float, controlY: Float, f3: Float, height: Float) {}
}