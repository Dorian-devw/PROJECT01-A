package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.DenunciaDao
import com.proyecto.project01_a.data.local.entities.Denuncia
import com.proyecto.project01_a.domain.model.DenunciaModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DenunciaRepository(
    private val denunciaDao: DenunciaDao
) {

    // Obtener todas las denuncias de un candidato
    fun getDenunciasByCandidato(candidatoId: Int): Flow<List<DenunciaModel>> =
        denunciaDao.getDenunciasByCandidato(candidatoId).map { list ->
            list.map { it.toDomain() }
        }

    // Insertar una denuncia
    suspend fun insertDenuncia(candidatoId: Int, denuncia: DenunciaModel): Long =
        denunciaDao.insert(denuncia.toEntity(candidatoId))

    // Insertar varias denuncias
    suspend fun insertAllDenuncias(candidatoId: Int, denuncias: List<DenunciaModel>) =
        denunciaDao.insertAll(denuncias.map { it.toEntity(candidatoId) })

    // Actualizar denuncia
    suspend fun updateDenuncia(candidatoId: Int, denuncia: DenunciaModel) =
        denunciaDao.update(denuncia.toEntity(candidatoId))

    // Eliminar denuncia
    suspend fun deleteDenuncia(candidatoId: Int, denuncia: DenunciaModel) =
        denunciaDao.delete(denuncia.toEntity(candidatoId))

    // Eliminar todas las denuncias
    suspend fun deleteAllDenuncias() = denunciaDao.deleteAll()

    // ===== MAPPERS =====
    private fun Denuncia.toDomain() = DenunciaModel(
        tipo = tipo,
        descripcion = descripcion,
        año = año,
        estado = estado,
        fuenteUrl = fuenteUrl
    )

    private fun DenunciaModel.toEntity(candidatoId: Int) = Denuncia(
        id = 0, // autogenerado
        candidatoId = candidatoId,
        tipo = tipo,
        descripcion = descripcion,
        año = año,
        estado = estado,
        fuenteUrl = fuenteUrl
    )
}
