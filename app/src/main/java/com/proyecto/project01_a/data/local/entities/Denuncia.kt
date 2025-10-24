package com.proyecto.project01_a.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "denuncias",
    foreignKeys = [
        ForeignKey(
            entity = Candidato::class,
            parentColumns = ["id"],
            childColumns = ["candidatoId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Denuncia(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val candidatoId: Int,
    val tipo: String,
    val descripcion: String,
    val año: Int,
    val estado: String,
    val fuenteUrl: String
)
