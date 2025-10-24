package com.proyecto.project01_a.domain.model

data class FinanciamientoModel(
    val montoDeclared: String,
    val fuentesPrincipales: List<String> = emptyList(),
    val transparencia: String // Alta, Media, Baja
)
