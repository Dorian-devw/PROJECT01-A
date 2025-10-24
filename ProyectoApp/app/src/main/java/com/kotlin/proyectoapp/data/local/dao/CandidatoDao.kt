package com.kotlin.proyectoapp.data.local.dao

import androidx.room.*
import com.kotlin.proyectoapp.data.local.entities.CandidatoEntity
import com.kotlin.proyectoapp.data.local.entities.CandidatoWithProyectosAndDenuncias
import kotlinx.coroutines.flow.Flow

@Dao
interface CandidatoDao {

    @Transaction
    @Query("SELECT * FROM candidatos")
    fun getCandidatosWithProyectosAndDenuncias(): Flow<List<CandidatoWithProyectosAndDenuncias>>

    @Transaction
    @Query("SELECT * FROM candidatos WHERE id = :id")
    fun getCandidatoWithProyectosAndDenunciasById(id: Int): Flow<CandidatoWithProyectosAndDenuncias?>

    @Query("SELECT * FROM candidatos ORDER BY apellidos ASC")
    fun getAllCandidatos(): Flow<List<CandidatoEntity>>

    @Query("SELECT * FROM candidatos WHERE id = :id")
    suspend fun getCandidatoById(id: Int): CandidatoEntity?

    @Query("""
        SELECT * FROM candidatos 
        WHERE nombre LIKE '%' || :query || '%' 
        OR apellidos LIKE '%' || :query || '%' 
        OR partido LIKE '%' || :query || '%'
        OR region LIKE '%' || :query || '%'
    """)
    fun searchCandidatos(query: String): Flow<List<CandidatoEntity>>

    @Query("SELECT * FROM candidatos WHERE cargo = :cargo")
    fun getCandidatosByCargo(cargo: String): Flow<List<CandidatoEntity>>

    @Query("SELECT * FROM candidatos WHERE partido = :partido")
    fun getCandidatosByPartido(partido: String): Flow<List<CandidatoEntity>>

    @Query("SELECT * FROM candidatos WHERE region = :region")
    fun getCandidatosByRegion(region: String): Flow<List<CandidatoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(candidato: CandidatoEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(candidatos: List<CandidatoEntity>)

    @Update
    suspend fun update(candidato: CandidatoEntity)

    @Delete
    suspend fun delete(candidato: CandidatoEntity)

    @Query("DELETE FROM candidatos")
    suspend fun deleteAll()
}