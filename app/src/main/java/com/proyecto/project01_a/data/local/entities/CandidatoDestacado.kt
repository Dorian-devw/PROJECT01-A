package com.proyecto.project01_a.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "candidatos_destacados",
    foreignKeys = [
        ForeignKey(
            entity = Partido::class,
            parentColumns = ["id"],
            childColumns = ["partidoId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CandidatoDestacado(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val partidoId: Int,
    val imagenResId: Int,
    val porcentaje: String
)
