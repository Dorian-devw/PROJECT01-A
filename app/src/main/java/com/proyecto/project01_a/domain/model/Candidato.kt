package com.proyecto.project01_a.domain.model

data class Candidato(
    val id: Int = 0,
    val nombre: String,
    val cargoPostula: String,
    val fotoUrl: String,
    val edad: Int,
    val profesion: String,
    val biografia: String,
    val partido: Partido,
    val propuestas: List<Propuesta> = emptyList(),
    val denuncias: List<Denuncia> = emptyList()
)
