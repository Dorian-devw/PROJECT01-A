package com.kotlin.proyectoapp.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class CandidatoWithProyectosAndDenuncias(
    @Embedded val candidato: CandidatoEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "candidatoId"
    )
    val proyectos: List<ProyectoEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "candidatoId"
    )
    val denuncias: List<DenunciaEntity>
)