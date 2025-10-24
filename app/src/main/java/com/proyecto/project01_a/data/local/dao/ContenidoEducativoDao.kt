package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.ContenidoEducativo
import kotlinx.coroutines.flow.Flow

@Dao
interface ContenidoEducativoDao {

    @Query("SELECT * FROM contenidos_educativos ORDER BY titulo ASC")
    fun getAllContenidos(): Flow<List<ContenidoEducativo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contenido: ContenidoEducativo): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contenidos: List<ContenidoEducativo>)

    @Update
    suspend fun update(contenido: ContenidoEducativo)

    @Delete
    suspend fun delete(contenido: ContenidoEducativo)

    @Query("DELETE FROM contenidos_educativos")
    suspend fun deleteAll()
}
