package com.proyecto.project01_a.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "redes_sociales",
    foreignKeys = [
        ForeignKey(
            entity = Candidato::class,
            parentColumns = ["id"],
            childColumns = ["candidatoId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RedesSociales(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val candidatoId: Int,
    val facebook: String?,
    val twitter: String?,
    val instagram: String?,
    val webOficial: String?
)
