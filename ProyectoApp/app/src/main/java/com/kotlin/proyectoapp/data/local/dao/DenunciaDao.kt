package com.kotlin.proyectoapp.data.local.dao

import androidx.room.*
import com.kotlin.proyectoapp.data.local.entities.DenunciaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DenunciaDao {

    @Query("SELECT * FROM denuncias WHERE candidatoId = :candidatoId ORDER BY fecha DESC")
    fun getDenunciasByCandidato(candidatoId: Int): Flow<List<DenunciaEntity>>

    @Query("SELECT * FROM denuncias WHERE id = :id")
    suspend fun getDenunciaById(id: Int): DenunciaEntity?

    @Query("SELECT * FROM denuncias WHERE tipo = :tipo")
    fun getDenunciasByTipo(tipo: String): Flow<List<DenunciaEntity>>

    @Query("SELECT * FROM denuncias WHERE estado = :estado")
    fun getDenunciasByEstado(estado: String): Flow<List<DenunciaEntity>>

    @Query("SELECT COUNT(*) FROM denuncias WHERE candidatoId = :candidatoId")
    suspend fun countDenunciasByCandidato(candidatoId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(denuncia: DenunciaEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(denuncias: List<DenunciaEntity>)

    @Update
    suspend fun update(denuncia: DenunciaEntity)

    @Delete
    suspend fun delete(denuncia: DenunciaEntity)

    @Query("DELETE FROM denuncias WHERE candidatoId = :candidatoId")
    suspend fun deleteAllByCandidato(candidatoId: Int)
}