package com.proyecto.project01_a.domain.model

data class CandidatoDestacadoModel(
    val id: Int = 0,
    val nombre: String,
    val partido: PartidoModel,
    val imagenResId: Int,
    val porcentaje: String
)
