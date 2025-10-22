package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.Candidato
import kotlinx.coroutines.flow.Flow

@Dao
interface CandidatoDao {

    @Query("SELECT * FROM candidatos ORDER BY nombre ASC")
    fun getAllCandidatos(): Flow<List<Candidato>>

    @Query("SELECT * FROM candidatos WHERE id = :id")
    suspend fun getCandidatoById(id: Int): Candidato?

    @Query("""
        SELECT * FROM candidatos 
        WHERE nombre LIKE '%' || :query || '%' 
        OR profesion LIKE '%' || :query || '%'
    """)
    fun searchCandidatos(query: String): Flow<List<Candidato>>

    @Query("SELECT * FROM candidatos WHERE partidoId = :partidoId")
    fun getCandidatosByPartido(partidoId: Int): Flow<List<Candidato>>

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
