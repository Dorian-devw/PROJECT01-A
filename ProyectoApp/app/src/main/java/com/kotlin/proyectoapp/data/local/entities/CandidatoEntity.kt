package com.kotlin.proyectoapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "candidatos")
data class CandidatoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val apellidos: String,
    val cargo: String, // Puede ser "Presidencia" o "Congreso"
    val partido: String,
    val region: String,
    val fotoUrl: String,
    val biografia: String,
    val fechaNacimiento: String,
    val profesion: String,
    val correo: String,
    val telefono: String
)