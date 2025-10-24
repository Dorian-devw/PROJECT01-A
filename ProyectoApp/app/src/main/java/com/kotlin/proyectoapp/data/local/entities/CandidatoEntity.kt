package com.kotlin.proyectoapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "candidatos")
data class CandidatoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val apellidos: String,
    val cargo: String,
    val partido: String,
    val region: String,
    val fotoUrl: String, // <-- Corregido a String
    val biografia: String,
    val fechaNacimiento: String,
    val profesion: String,
    val correo: String,
    val telefono: String
)