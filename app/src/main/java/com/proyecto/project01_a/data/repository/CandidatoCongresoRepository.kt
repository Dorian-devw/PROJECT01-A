package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.CandidatoCongresoDao
import com.proyecto.project01_a.data.local.entities.CandidatoCongreso
import com.proyecto.project01_a.domain.model.CandidatoCongresoModel
import com.proyecto.project01_a.domain.model.PartidoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CandidatoCongresoRepository(
    private val candidatoCongresoDao: CandidatoCongresoDao
) {

    fun getAllCandidatosCongreso(): Flow<List<CandidatoCongresoModel>> {
        return candidatoCongresoDao.getAllCandidatos().map { list ->
            list.map { it.toDomain() }
        }
    }

    fun getCandidatoCongresoById(id: Int): Flow<CandidatoCongresoModel?> {
        return candidatoCongresoDao.getCandidatoByIdFlow(id).map { it?.toDomain() }
    }

    suspend fun insertCandidatoCongreso(candidato: CandidatoCongresoModel): Long {
        return candidatoCongresoDao.insert(candidato.toEntity())
    }

    suspend fun updateCandidatoCongreso(candidato: CandidatoCongresoModel) {
        candidatoCongresoDao.update(candidato.toEntity())
    }

    suspend fun deleteCandidatoCongreso(candidato: CandidatoCongresoModel) {
        candidatoCongresoDao.delete(candidato.toEntity())
    }

    suspend fun deleteAllCandidatosCongreso() {
        candidatoCongresoDao.deleteAll()
    }

    // ===== Mappers =====
    private fun CandidatoCongreso.toDomain(): CandidatoCongresoModel = CandidatoCongresoModel(
        id = id,
        nombre = nombre,
        partido = PartidoModel(
            id = partidoId,
            nombre = "",
            nombreCorto = "",
            logoUrl = "",
            fundacion = 0,
            ideologia = "",
            descripcion = "",
            lider = "",
            miembrosDestacados = emptyList(),
            propuestasGenerales = emptyList(),
            webOficial = null
        ),
        region = region,
        fotoUrl = fotoUrl,
        edad = edad,
        profesion = profesion,
        historial = historial,
        propuestas = emptyList()
    )

    private fun CandidatoCongresoModel.toEntity(): CandidatoCongreso = CandidatoCongreso(
        id = id,
        nombre = nombre,
        partidoId = partido.id,
        region = region,
        fotoUrl = fotoUrl,
        edad = edad,
        profesion = profesion,
        historial = historial
    )
}
