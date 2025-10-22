package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.Denuncia
import kotlinx.coroutines.flow.Flow

@Dao
interface DenunciaDao {

    @Query("SELECT * FROM denuncias ORDER BY año DESC")
    fun getAllDenuncias(): Flow<List<Denuncia>>

    @Query("SELECT * FROM denuncias WHERE id = :id")
    suspend fun getDenunciaById(id: Int): Denuncia?

    @Query("SELECT * FROM denuncias WHERE candidatoId = :candidatoId")
    fun getDenunciasByCandidato(candidatoId: Int): Flow<List<Denuncia>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(denuncia: Denuncia): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(denuncias: List<Denuncia>)

    @Update
    suspend fun update(denuncia: Denuncia)

    @Delete
    suspend fun delete(denuncia: Denuncia)

    @Query("DELETE FROM denuncias")
    suspend fun deleteAll()
}
