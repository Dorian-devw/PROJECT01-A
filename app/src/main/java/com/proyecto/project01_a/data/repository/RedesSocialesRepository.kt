package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.RedesSocialesDao
import com.proyecto.project01_a.data.local.entities.RedesSociales
import com.proyecto.project01_a.domain.model.RedesSocialesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RedesSocialesRepository(
    private val redesSocialesDao: RedesSocialesDao
) {

    // Obtener redes sociales de un candidato
    fun getRedesByCandidato(candidatoId: Int): Flow<RedesSocialesModel?> =
        redesSocialesDao.getRedesByCandidato(candidatoId).map { it?.toDomain() }

    // Insertar nuevas redes sociales
    suspend fun insertRedes(candidatoId: Int, redes: RedesSocialesModel): Long =
        redesSocialesDao.insert(redes.toEntity(candidatoId))

    // Actualizar redes sociales
    suspend fun updateRedes(candidatoId: Int, redes: RedesSocialesModel) =
        redesSocialesDao.update(redes.toEntity(candidatoId))

    // Eliminar redes sociales
    suspend fun deleteRedes(candidatoId: Int, redes: RedesSocialesModel) =
        redesSocialesDao.delete(redes.toEntity(candidatoId))

    // Eliminar todas las redes sociales (por limpieza general)
    suspend fun deleteAllRedes() = redesSocialesDao.deleteAll()

    // ===== MAPPERS =====
    private fun RedesSociales.toDomain() = RedesSocialesModel(
        facebook = facebook,
        twitter = twitter,
        instagram = instagram,
        webOficial = webOficial
    )

    private fun RedesSocialesModel.toEntity(candidatoId: Int) = RedesSociales(
        id = 0, // autogenerado
        candidatoId = candidatoId,
        facebook = facebook,
        twitter = twitter,
        instagram = instagram,
        webOficial = webOficial
    )
}
