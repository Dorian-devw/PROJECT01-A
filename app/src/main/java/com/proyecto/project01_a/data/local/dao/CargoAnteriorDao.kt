package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.CargoAnterior
import kotlinx.coroutines.flow.Flow

@Dao
interface CargoAnteriorDao {

    @Query("SELECT * FROM cargos_anteriores WHERE candidatoId = :candidatoId")
    fun getCargosByCandidato(candidatoId: Int): Flow<List<CargoAnterior>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cargo: CargoAnterior): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cargos: List<CargoAnterior>)

    @Update
    suspend fun update(cargo: CargoAnterior)

    @Delete
    suspend fun delete(cargo: CargoAnterior)

    @Query("DELETE FROM cargos_anteriores")
    suspend fun deleteAll()
}
