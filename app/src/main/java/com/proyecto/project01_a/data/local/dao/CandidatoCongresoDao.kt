package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.CandidatoCongreso
import kotlinx.coroutines.flow.Flow

@Dao
interface CandidatoCongresoDao {

    @Query("SELECT * FROM candidatos_congreso ORDER BY nombre ASC")
    fun getAllCandidatos(): Flow<List<CandidatoCongreso>>

    @Query("SELECT * FROM candidatos_congreso WHERE id = :id")
    suspend fun getCandidatoById(id: Int): CandidatoCongreso?

    @Query("SELECT * FROM candidatos_congreso WHERE id = :id")
    fun getCandidatoByIdFlow(id: Int): Flow<CandidatoCongreso?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(candidato: CandidatoCongreso): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(candidatos: List<CandidatoCongreso>)

    @Update
    suspend fun update(candidato: CandidatoCongreso)

    @Delete
    suspend fun delete(candidato: CandidatoCongreso)

    @Query("DELETE FROM candidatos_congreso")
    suspend fun deleteAll()
}
