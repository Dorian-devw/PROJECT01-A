package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.PartidoDao
import com.proyecto.project01_a.data.local.entities.Partido
import kotlinx.coroutines.flow.Flow

class PartidoRepository(private val partidoDao: PartidoDao) {

    fun getAllPartidos(): Flow<List<Partido>> = partidoDao.getAllPartidos()

    suspend fun getPartidoById(id: Int): Partido? = partidoDao.getPartidoById(id)

    suspend fun insert(partido: Partido): Long = partidoDao.insert(partido)

    suspend fun insertAll(partidos: List<Partido>) = partidoDao.insertAll(partidos)

    suspend fun update(partido: Partido) = partidoDao.update(partido)

    suspend fun delete(partido: Partido) = partidoDao.delete(partido)

    suspend fun deleteAll() = partidoDao.deleteAll()
}
