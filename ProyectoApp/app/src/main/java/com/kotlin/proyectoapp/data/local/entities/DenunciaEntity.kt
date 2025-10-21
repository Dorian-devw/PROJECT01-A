package com.kotlin.proyectoapp.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "denuncias",
    foreignKeys = [ForeignKey(
        entity = CandidatoEntity::class,
        parentColumns = ["id"],
        childColumns = ["candidatoId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class DenunciaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val candidatoId: Int,
    val tipo: String, // Puede ser "Penal", "Civil", "Electoral"
    val descripcion: String,
    val fecha: String,
    val estado: String, // "En proceso", "Archivado", "Sentenciado"
    val urlFuente: String
)