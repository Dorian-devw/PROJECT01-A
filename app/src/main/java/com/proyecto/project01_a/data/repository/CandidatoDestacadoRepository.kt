package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.CandidatoDestacadoDao
import com.proyecto.project01_a.data.local.entities.CandidatoDestacado
import com.proyecto.project01_a.domain.model.CandidatoDestacadoModel
import com.proyecto.project01_a.domain.model.PartidoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CandidatoDestacadoRepository(
    private val candidatoDestacadoDao: CandidatoDestacadoDao
) {

    // Obtener todos los candidatos destacados ordenados por porcentaje (de mayor a menor)
    fun getAllCandidatosDestacados(): Flow<List<CandidatoDestacadoModel>> {
        return candidatoDestacadoDao.getAllDestacados().map { list ->
            list.map { it.toDomain() }
        }
    }

    // Insertar un candidato destacado
    suspend fun insertCandidatoDestacado(candidato: CandidatoDestacadoModel): Long {
        return candidatoDestacadoDao.insert(candidato.toEntity())
    }

    // Insertar varios candidatos destacados
    suspend fun insertAllCandidatosDestacados(candidatos: List<CandidatoDestacadoModel>) {
        candidatoDestacadoDao.insertAll(candidatos.map { it.toEntity() })
    }

    // Actualizar un candidato destacado
    suspend fun updateCandidatoDestacado(candidato: CandidatoDestacadoModel) {
        candidatoDestacadoDao.update(candidato.toEntity())
    }

    // Eliminar un candidato destacado
    suspend fun deleteCandidatoDestacado(candidato: CandidatoDestacadoModel) {
        candidatoDestacadoDao.delete(candidato.toEntity())
    }

    // Eliminar todos los candidatos destacados
    suspend fun deleteAllCandidatosDestacados() {
        candidatoDestacadoDao.deleteAll()
    }

    // ======== MAPPERS ========

    private fun CandidatoDestacado.toDomain(): CandidatoDestacadoModel = CandidatoDestacadoModel(
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
        imagenResId = imagenResId,
        porcentaje = porcentaje
    )

    private fun CandidatoDestacadoModel.toEntity(): CandidatoDestacado = CandidatoDestacado(
        id = id,
        nombre = nombre,
        partidoId = partido.id,
        imagenResId = imagenResId,
        porcentaje = porcentaje
    )
}
