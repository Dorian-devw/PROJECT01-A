package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.Noticia
import kotlinx.coroutines.flow.Flow

@Dao
interface NoticiaDao {

    @Query("SELECT * FROM noticias ORDER BY fecha DESC")
    fun getAllNoticias(): Flow<List<Noticia>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noticia: Noticia): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(noticias: List<Noticia>)

    @Update
    suspend fun update(noticia: Noticia)

    @Delete
    suspend fun delete(noticia: Noticia)

    @Query("DELETE FROM noticias")
    suspend fun deleteAll()
}
