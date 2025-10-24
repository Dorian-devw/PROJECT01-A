package com.proyecto.project01_a.domain.model

data class CandidatoCongresoModel(
    val id: Int = 0,
    val nombre: String,
    val partido: PartidoModel,
    val region: String,
    val fotoUrl: String,
    val edad: Int,
    val profesion: String,
    val propuestas: List<String> = emptyList(),
    val historial: String
)
