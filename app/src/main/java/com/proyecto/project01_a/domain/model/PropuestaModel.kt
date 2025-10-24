package com.proyecto.project01_a.domain.model

data class PropuestaModel(
    val id: Int = 0,
    val candidatoId: Int,
    val categoria: String,
    val titulo: String,
    val descripcion: String,
    val prioridad: String // Alta, Media, Baja
)
