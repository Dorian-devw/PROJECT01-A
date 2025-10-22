package com.proyecto.project01_a.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partidos")
data class Partido(
    @PrimaryKey(autoGenerate = true)
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
