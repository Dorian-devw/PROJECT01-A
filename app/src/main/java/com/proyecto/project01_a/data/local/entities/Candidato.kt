package com.proyecto.project01_a.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "candidatos",
    foreignKeys = [
        ForeignKey(
            entity = Partido::class,
            parentColumns = ["id"],
            childColumns = ["partidoId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Candidato(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val partidoId: Int,
    val cargoPostula: String,
    val fotoUrl: String,
    val edad: Int,
    val profesion: String,
    val biografia: String
)
