package com.proyecto.project01_a.domain.model

data class NoticiaModel(
    val id: Int = 0,
    val titulo: String,
    val descripcion: String,
    val fuente: String,
    val fecha: String,
    val imagenUrl: String,
    val url: String,
    val categoria: String // Política, Economía, Social
)
