package com.proyecto.project01_a.domain.model

data class Propuesta(
    val id: Int = 0,
    val categoria: String,
    val titulo: String,
    val descripcion: String,
    val prioridad: String // Alta, Media, Baja
)
