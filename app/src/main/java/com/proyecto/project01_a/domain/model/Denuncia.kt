package com.proyecto.project01_a.domain.model

data class Denuncia(
    val id: Int = 0,
    val tipo: String,
    val descripcion: String,
    val año: Int,
    val estado: String,
    val fuenteUrl: String
)
