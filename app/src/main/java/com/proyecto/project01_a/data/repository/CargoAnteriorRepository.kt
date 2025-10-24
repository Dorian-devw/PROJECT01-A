package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.CargoAnteriorDao
import com.proyecto.project01_a.data.local.entities.CargoAnterior
import com.proyecto.project01_a.domain.model.CargoAnteriorModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CargoAnteriorRepository(
    private val cargoAnteriorDao: CargoAnteriorDao
) {

    // Obtener todos los cargos anteriores de un candidato
    fun getCargosByCandidato(candidatoId: Int): Flow<List<CargoAnteriorModel>> =
        cargoAnteriorDao.getCargosByCandidato(candidatoId).map { lista ->
            lista.map { it.toDomain() }
        }

    // Insertar un nuevo cargo anterior
    suspend fun insertCargo(candidatoId: Int, cargo: CargoAnteriorModel): Long =
        cargoAnteriorDao.insert(cargo.toEntity(candidatoId))

    // Insertar varios cargos a la vez
    suspend fun insertAllCargos(candidatoId: Int, cargos: List<CargoAnteriorModel>) {
        cargoAnteriorDao.insertAll(cargos.map { it.toEntity(candidatoId) })
    }

    // Actualizar un cargo anterior
    suspend fun updateCargo(candidatoId: Int, cargo: CargoAnteriorModel) =
        cargoAnteriorDao.update(cargo.toEntity(candidatoId))

    // Eliminar un cargo anterior
    suspend fun deleteCargo(candidatoId: Int, cargo: CargoAnteriorModel) =
        cargoAnteriorDao.delete(cargo.toEntity(candidatoId))

    // Eliminar todos los registros (limpieza general)
    suspend fun deleteAllCargos() = cargoAnteriorDao.deleteAll()

    // ====== MAPPERS ======
    private fun CargoAnterior.toDomain() = CargoAnteriorModel(
        cargo = cargo,
        institucion = institucion,
        periodo = periodo,
        descripcion = descripcion
    )

    private fun CargoAnteriorModel.toEntity(candidatoId: Int) = CargoAnterior(
        id = 0, // autogenerado
        candidatoId = candidatoId,
        cargo = cargo,
        institucion = institucion,
        periodo = periodo,
        descripcion = descripcion
    )
}
