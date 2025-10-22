package com.proyecto.project01_a.domain.model

data class Partido(
    val id: Int = 0,
    val nombre: String,
    val nombreCorto: String,
    val logoUrl: String,
    val fundacion: Int,
    val ideologia: String,
    val descripcion: String,
    val lider: String,
    val webOficial: String?
)
