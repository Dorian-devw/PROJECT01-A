package com.proyecto.project01_a.domain.model

data class ContenidoEducativoModel(
    val id: Int = 0,
    val titulo: String,
    val descripcion: String,
    val categoria: String,
    val contenido: String,
    val iconoUrl: String?
)
