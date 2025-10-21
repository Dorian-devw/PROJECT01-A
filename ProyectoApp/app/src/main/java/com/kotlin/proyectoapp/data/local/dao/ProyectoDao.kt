package com.kotlin.proyectoapp.data.local.dao

import androidx.room.*
import com.kotlin.proyectoapp.data.local.entities.ProyectoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProyectoDao {

    @Query("SELECT * FROM proyectos WHERE candidatoId = :candidatoId ORDER BY fecha DESC")
    fun getProyectosByCandidato(candidatoId: Int): Flow<List<ProyectoEntity>>

    @Query("SELECT * FROM proyectos WHERE id = :id")
    suspend fun getProyectoById(id: Int): ProyectoEntity?

    @Query("SELECT * FROM proyectos WHERE estado = :estado")
    fun getProyectosByEstado(estado: String): Flow<List<ProyectoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(proyecto: ProyectoEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(proyectos: List<ProyectoEntity>)

    @Update
    suspend fun update(proyecto: ProyectoEntity)

    @Delete
    suspend fun delete(proyecto: ProyectoEntity)

    @Query("DELETE FROM proyectos WHERE candidatoId = :candidatoId")
    suspend fun deleteAllByCandidato(candidatoId: Int)
}