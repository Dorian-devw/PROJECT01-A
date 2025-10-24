package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.Propuesta
import kotlinx.coroutines.flow.Flow

@Dao
interface PropuestaDao {

    @Query("SELECT * FROM propuestas WHERE candidatoId = :candidatoId")
    fun getPropuestasByCandidato(candidatoId: Int): Flow<List<Propuesta>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(propuesta: Propuesta): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(propuestas: List<Propuesta>)

    @Update
    suspend fun update(propuesta: Propuesta)

    @Delete
    suspend fun delete(propuesta: Propuesta)

    @Query("DELETE FROM propuestas")
    suspend fun deleteAll()
}
