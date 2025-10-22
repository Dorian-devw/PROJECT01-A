package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.PropuestaDao
import com.proyecto.project01_a.data.local.entities.Propuesta
import kotlinx.coroutines.flow.Flow

class PropuestaRepository(private val propuestaDao: PropuestaDao) {

    fun getAllPropuestas(): Flow<List<Propuesta>> = propuestaDao.getAllPropuestas()

    fun getPropuestasByCandidato(candidatoId: Int): Flow<List<Propuesta>> =
        propuestaDao.getPropuestasByCandidato(candidatoId)

    suspend fun getPropuestaById(id: Int): Propuesta? = propuestaDao.getPropuestaById(id)

    suspend fun insert(propuesta: Propuesta): Long = propuestaDao.insert(propuesta)

    suspend fun insertAll(propuestas: List<Propuesta>) = propuestaDao.insertAll(propuestas)

    suspend fun update(propuesta: Propuesta) = propuestaDao.update(propuesta)

    suspend fun delete(propuesta: Propuesta) = propuestaDao.delete(propuesta)

    suspend fun deleteAll() = propuestaDao.deleteAll()
}
