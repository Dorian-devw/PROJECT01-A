package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.PartidoDao
import com.proyecto.project01_a.data.local.entities.Partido
import com.proyecto.project01_a.domain.model.PartidoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PartidoRepository(
    private val partidoDao: PartidoDao
) {

    fun getAllPartidos(): Flow<List<PartidoModel>> {
        return partidoDao.getAllPartidos().map { list ->
            list.map { it.toDomain() }
        }
    }

    fun getPartidoById(id: Int): Flow<PartidoModel?> {
        return partidoDao.getPartidoByIdFlow(id).map { it?.toDomain() }
    }

    suspend fun insertPartido(partido: PartidoModel): Long {
        return partidoDao.insert(partido.toEntity())
    }

    suspend fun updatePartido(partido: PartidoModel) {
        partidoDao.update(partido.toEntity())
    }

    suspend fun deletePartido(partido: PartidoModel) {
        partidoDao.delete(partido.toEntity())
    }

    suspend fun deleteAllPartidos() {
        partidoDao.deleteAll()
    }
    private fun Partido.toDomain(): PartidoModel = PartidoModel(
        id = id,
        nombre = nombre,
        nombreCorto = nombreCorto,
        logoUrl = logoUrl,
        fundacion = fundacion,
        ideologia = ideologia,
        descripcion = descripcion,
        lider = lider,
        miembrosDestacados = emptyList(),
        propuestasGenerales = emptyList(),
        webOficial = webOficial
    )

    private fun PartidoModel.toEntity(): Partido = Partido(
        id = id,
        nombre = nombre,
        nombreCorto = nombreCorto,
        logoUrl = logoUrl,
        fundacion = fundacion,
        ideologia = ideologia,
        descripcion = descripcion,
        lider = lider,
        webOficial = webOficial
    )
}
