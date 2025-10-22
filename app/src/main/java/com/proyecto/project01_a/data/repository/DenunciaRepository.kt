package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.DenunciaDao
import com.proyecto.project01_a.data.local.entities.Denuncia
import kotlinx.coroutines.flow.Flow

class DenunciaRepository(private val denunciaDao: DenunciaDao) {

    fun getAllDenuncias(): Flow<List<Denuncia>> = denunciaDao.getAllDenuncias()

    fun getDenunciasByCandidato(candidatoId: Int): Flow<List<Denuncia>> =
        denunciaDao.getDenunciasByCandidato(candidatoId)

    suspend fun getDenunciaById(id: Int): Denuncia? = denunciaDao.getDenunciaById(id)

    suspend fun insert(denuncia: Denuncia): Long = denunciaDao.insert(denuncia)

    suspend fun insertAll(denuncias: List<Denuncia>) = denunciaDao.insertAll(denuncias)

    suspend fun update(denuncia: Denuncia) = denunciaDao.update(denuncia)

    suspend fun delete(denuncia: Denuncia) = denunciaDao.delete(denuncia)

    suspend fun deleteAll() = denunciaDao.deleteAll()
}
