package com.kotlin.proyectoapp.domain.model

data class Denuncia(
    val id: Int = 0,
    val candidatoId: Int,
    val tipo: String,
    val descripcion: String,
    val fecha: String,
    val estado: String,
    val urlFuente: String
)