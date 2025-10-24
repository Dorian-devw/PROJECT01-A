package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.Financiamiento
import kotlinx.coroutines.flow.Flow

@Dao
interface FinanciamientoDao {

    @Query("SELECT * FROM financiamientos WHERE candidatoId = :candidatoId")
    fun getFinanciamientoByCandidato(candidatoId: Int): Flow<Financiamiento?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(financiamiento: Financiamiento): Long

    @Update
    suspend fun update(financiamiento: Financiamiento)

    @Delete
    suspend fun delete(financiamiento: Financiamiento)

    @Query("DELETE FROM financiamientos")
    suspend fun deleteAll()
}
