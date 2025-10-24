package com.proyecto.project01_a.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contenidos_educativos")
data class ContenidoEducativo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val descripcion: String,
    val categoria: String,
    val contenido: String,
    val iconoUrl: String?
)
