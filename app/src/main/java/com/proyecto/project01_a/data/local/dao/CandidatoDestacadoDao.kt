package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.CandidatoDestacado
import kotlinx.coroutines.flow.Flow

@Dao
interface CandidatoDestacadoDao {

    @Query("SELECT * FROM candidatos_destacados ORDER BY porcentaje DESC")
    fun getAllDestacados(): Flow<List<CandidatoDestacado>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(destacado: CandidatoDestacado): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(destacados: List<CandidatoDestacado>)

    @Update
    suspend fun update(destacado: CandidatoDestacado)

    @Delete
    suspend fun delete(destacado: CandidatoDestacado)

    @Query("DELETE FROM candidatos_destacados")
    suspend fun deleteAll()
}
