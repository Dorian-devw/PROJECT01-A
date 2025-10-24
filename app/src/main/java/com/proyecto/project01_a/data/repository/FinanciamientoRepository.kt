package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.FinanciamientoDao
import com.proyecto.project01_a.data.local.entities.Financiamiento
import com.proyecto.project01_a.domain.model.FinanciamientoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FinanciamientoRepository(
    private val financiamientoDao: FinanciamientoDao
) {

    // Obtener el financiamiento de un candidato
    fun getFinanciamientoByCandidato(candidatoId: Int): Flow<FinanciamientoModel?> =
        financiamientoDao.getFinanciamientoByCandidato(candidatoId).map { it?.toDomain() }

    // Insertar nuevo registro de financiamiento
    suspend fun insertFinanciamiento(candidatoId: Int, financiamiento: FinanciamientoModel): Long =
        financiamientoDao.insert(financiamiento.toEntity(candidatoId))

    // Actualizar financiamiento existente
    suspend fun updateFinanciamiento(candidatoId: Int, financiamiento: FinanciamientoModel) =
        financiamientoDao.update(financiamiento.toEntity(candidatoId))

    // Eliminar financiamiento de un candidato
    suspend fun deleteFinanciamiento(candidatoId: Int, financiamiento: FinanciamientoModel) =
        financiamientoDao.delete(financiamiento.toEntity(candidatoId))

    // Eliminar todos los registros (limpieza general)
    suspend fun deleteAllFinanciamientos() = financiamientoDao.deleteAll()

    // ===== MAPPERS =====
    private fun Financiamiento.toDomain() = FinanciamientoModel(
        montoDeclared = montoDeclared,
        transparencia = transparencia,
        fuentesPrincipales = emptyList() // No se almacena en BD aún
    )

    private fun FinanciamientoModel.toEntity(candidatoId: Int) = Financiamiento(
        id = 0, // autogenerado
        candidatoId = candidatoId,
        montoDeclared = montoDeclared,
        transparencia = transparencia
    )
}
