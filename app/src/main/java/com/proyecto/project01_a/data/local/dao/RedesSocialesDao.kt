package com.proyecto.project01_a.data.local.dao

import androidx.room.*
import com.proyecto.project01_a.data.local.entities.RedesSociales
import kotlinx.coroutines.flow.Flow

@Dao
interface RedesSocialesDao {

    @Query("SELECT * FROM redes_sociales WHERE candidatoId = :candidatoId")
    fun getRedesByCandidato(candidatoId: Int): Flow<RedesSociales?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(redes: RedesSociales): Long

    @Update
    suspend fun update(redes: RedesSociales)

    @Delete
    suspend fun delete(redes: RedesSociales)

    @Query("DELETE FROM redes_sociales")
    suspend fun deleteAll()
}
