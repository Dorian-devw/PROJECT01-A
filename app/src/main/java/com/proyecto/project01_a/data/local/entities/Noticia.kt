package com.proyecto.project01_a.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noticias")
data class Noticia(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val descripcion: String,
    val fuente: String,
    val fecha: String,
    val imagenUrl: String,
    val url: String,
    val categoria: String
)
