package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.Partido
import kotlinx.coroutines.flow.Flow

@Dao
interface PartidoDao {

    @Query("SELECT * FROM partidos ORDER BY nombre ASC")
    fun getAllPartidos(): Flow<List<Partido>>

    @Query("SELECT * FROM partidos WHERE id = :id")
    suspend fun getPartidoById(id: Int): Partido?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido: Partido): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(partidos: List<Partido>)

    @Update
    suspend fun update(partido: Partido)

    @Delete
    suspend fun delete(partido: Partido)

    @Query("DELETE FROM partidos")
    suspend fun deleteAll()
}
