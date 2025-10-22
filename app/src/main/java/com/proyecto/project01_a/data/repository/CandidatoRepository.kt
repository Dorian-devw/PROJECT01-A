package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.CandidatoDao
import com.proyecto.project01_a.data.local.entities.Candidato
import kotlinx.coroutines.flow.Flow

class CandidatoRepository(private val candidatoDao: CandidatoDao) {

    fun getAllCandidatos(): Flow<List<Candidato>> = candidatoDao.getAllCandidatos()

    suspend fun getCandidatoById(id: Int): Candidato? = candidatoDao.getCandidatoById(id)

    fun searchCandidatos(query: String): Flow<List<Candidato>> = candidatoDao.searchCandidatos(query)

    fun getCandidatosByPartido(partidoId: Int): Flow<List<Candidato>> =
        candidatoDao.getCandidatosByPartido(partidoId)

    suspend fun insert(candidato: Candidato): Long = candidatoDao.insert(candidato)

    suspend fun insertAll(candidatos: List<Candidato>) = candidatoDao.insertAll(candidatos)

    suspend fun update(candidato: Candidato) = candidatoDao.update(candidato)

    suspend fun delete(candidato: Candidato) = candidatoDao.delete(candidato)

    suspend fun deleteAll() = candidatoDao.deleteAll()
}
