package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.Candidato
import com.proyecto.project01_a.data.local.relations.CandidatoRelations
import kotlinx.coroutines.flow.Flow

@Dao
interface CandidatoDao {

    @Transaction
    @Query("SELECT * FROM candidatos ORDER BY nombre ASC")
    fun getAllCandidatosRelations(): Flow<List<CandidatoRelations>>

    @Transaction
    @Query("SELECT * FROM candidatos WHERE id = :id")
    fun getCandidatoRelationsById(id: Int): Flow<CandidatoRelations>

    @Query("SELECT * FROM candidatos ORDER BY nombre ASC")
    fun getAllCandidatos(): Flow<List<Candidato>>

    @Query("SELECT * FROM candidatos WHERE id = :id")
    suspend fun getCandidatoById(id: Int): Candidato?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(candidato: Candidato): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(candidatos: List<Candidato>)

    @Update
    suspend fun update(candidato: Candidato)

    @Delete
    suspend fun delete(candidato: Candidato)

    @Query("DELETE FROM candidatos")
    suspend fun deleteAll()
}
