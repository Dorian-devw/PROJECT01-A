package com.proyecto.project01_a.domain.model

data class PartidoModel(
    val id: Int = 0,
    val nombre: String,
    val nombreCorto: String,
    val logoUrl: String,
    val fundacion: Int,
    val ideologia: String,
    val descripcion: String,
    val lider: String,
    val miembrosDestacados: List<String> = emptyList(),
    val propuestasGenerales: List<String> = emptyList(),
    val webOficial: String?
)
