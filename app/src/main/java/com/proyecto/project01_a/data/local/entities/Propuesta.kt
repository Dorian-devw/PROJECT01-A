package com.proyecto.project01_a.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "propuestas",
    foreignKeys = [ForeignKey(
        entity = Candidato::class,
        parentColumns = ["id"],
        childColumns = ["candidatoId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Propuesta(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val candidatoId: Int,
    val categoria: String,
    val titulo: String,
    val descripcion: String,
    val prioridad: String // Alta, Media, Baja
)
