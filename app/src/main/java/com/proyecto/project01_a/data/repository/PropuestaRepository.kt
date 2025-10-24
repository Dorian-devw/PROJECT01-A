package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.PropuestaDao
import com.proyecto.project01_a.data.local.entities.Propuesta
import com.proyecto.project01_a.domain.model.PropuestaModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PropuestaRepository(
    private val propuestaDao: PropuestaDao
) {

    // Obtener todas las propuestas de un candidato
    fun getPropuestasByCandidato(candidatoId: Int): Flow<List<PropuestaModel>> =
        propuestaDao.getPropuestasByCandidato(candidatoId).map { list ->
            list.map { it.toDomain() }
        }

    // Insertar una propuesta
    suspend fun insertPropuesta(propuesta: PropuestaModel): Long =
        propuestaDao.insert(propuesta.toEntity())

    // Insertar varias propuestas
    suspend fun insertAllPropuestas(propuestas: List<PropuestaModel>) =
        propuestaDao.insertAll(propuestas.map { it.toEntity() })

    // Actualizar
    suspend fun updatePropuesta(propuesta: PropuestaModel) =
        propuestaDao.update(propuesta.toEntity())

    // Eliminar una
    suspend fun deletePropuesta(propuesta: PropuestaModel) =
        propuestaDao.delete(propuesta.toEntity())

    // Eliminar todas
    suspend fun deleteAllPropuestas() = propuestaDao.deleteAll()

    // Mapeos entre entidad y modelo
    private fun Propuesta.toDomain() = PropuestaModel(
        id = id,
        categoria = categoria,
        titulo = titulo,
        descripcion = descripcion,
        prioridad = prioridad,
        candidatoId = candidatoId
    )

    private fun PropuestaModel.toEntity() = Propuesta(
        id = id,
        categoria = categoria,
        titulo = titulo,
        descripcion = descripcion,
        prioridad = prioridad,
        candidatoId = candidatoId
    )
}
