package com.proyecto.project01_a.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "cargos_anteriores",
    foreignKeys = [
        ForeignKey(
            entity = Candidato::class,
            parentColumns = ["id"],
            childColumns = ["candidatoId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CargoAnterior(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val candidatoId: Int,
    val cargo: String,
    val institucion: String,
    val periodo: String,
    val descripcion: String
)
