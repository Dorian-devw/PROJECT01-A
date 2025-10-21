package com.kotlin.proyectoapp.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "proyectos",
    foreignKeys = [ForeignKey(
        entity = CandidatoEntity::class,
        parentColumns = ["id"],
        childColumns = ["candidatoId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ProyectoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val candidatoId: Int,
    val titulo: String,
    val descripcion: String,
    val fecha: String,
    val estado: String, // Puede ser "Aprobado", "En trámite", "Rechazado"
    val urlFuente: String
)