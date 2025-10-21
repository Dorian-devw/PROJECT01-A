package com.kotlin.proyectoapp.domain.model

data class Proyecto(
    val id: Int = 0,
    val candidatoId: Int,
    val titulo: String,
    val descripcion: String,
    val fecha: String,
    val estado: String,
    val urlFuente: String
)