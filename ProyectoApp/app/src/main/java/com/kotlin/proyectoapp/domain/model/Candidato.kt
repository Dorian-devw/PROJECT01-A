package com.kotlin.proyectoapp.domain.model

data class Candidato(
    val id: Int = 0,
    val nombre: String,
    val apellidos: String,
    val nombreCompleto: String = "$nombre $apellidos",
    val cargo: String,
    val partido: String,
    val region: String,
    val fotoUrl: String, // <-- Corregido a String
    val biografia: String,
    val fechaNacimiento: String,
    val profesion: String,
    val correo: String,
    val telefono: String,
    val proyectos: List<Proyecto> = emptyList(),
    val denuncias: List<Denuncia> = emptyList()
)