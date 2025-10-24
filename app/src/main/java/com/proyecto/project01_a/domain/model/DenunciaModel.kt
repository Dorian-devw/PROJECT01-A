package com.proyecto.project01_a.domain.model

data class DenunciaModel(
    val tipo: String,
    val descripcion: String,
    val año: Int,
    val estado: String, // Archivado, En proceso, Sentenciado
    val fuenteUrl: String
)
