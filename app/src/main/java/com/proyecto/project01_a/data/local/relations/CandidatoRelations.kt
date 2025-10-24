package com.proyecto.project01_a.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.proyecto.project01_a.data.local.entities.*

data class CandidatoRelations(
    @Embedded val candidato: Candidato,

    @Relation(
        parentColumn = "partidoId",
        entityColumn = "id"
    )
    val partido: Partido,

    @Relation(
        parentColumn = "id",
        entityColumn = "candidatoId"
    )
    val propuestas: List<Propuesta> = emptyList(),

    @Relation(
        parentColumn = "id",
        entityColumn = "candidatoId"
    )
    val denuncias: List<Denuncia> = emptyList(),

    @Relation(
        parentColumn = "id",
        entityColumn = "candidatoId"
    )
    val cargos: List<CargoAnterior> = emptyList(),

    @Relation(
        parentColumn = "id",
        entityColumn = "candidatoId"
    )
    val financiamiento: Financiamiento? = null,

    @Relation(
        parentColumn = "id",
        entityColumn = "candidatoId"
    )
    val redesSociales: RedesSociales? = null
)
