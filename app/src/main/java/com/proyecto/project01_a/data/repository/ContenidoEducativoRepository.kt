package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.ContenidoEducativoDao
import com.proyecto.project01_a.data.local.entities.ContenidoEducativo
import com.proyecto.project01_a.domain.model.ContenidoEducativoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ContenidoEducativoRepository(
    private val contenidoEducativoDao: ContenidoEducativoDao
) {

    // Obtener todos los contenidos educativos ordenados por título
    fun getAllContenidos(): Flow<List<ContenidoEducativoModel>> {
        return contenidoEducativoDao.getAllContenidos().map { list ->
            list.map { it.toDomain() }
        }
    }

    // Insertar un contenido educativo
    suspend fun insertContenido(contenido: ContenidoEducativoModel): Long {
        return contenidoEducativoDao.insert(contenido.toEntity())
    }

    // Insertar varios contenidos educativos
    suspend fun insertAllContenidos(contenidos: List<ContenidoEducativoModel>) {
        contenidoEducativoDao.insertAll(contenidos.map { it.toEntity() })
    }

    // Actualizar un contenido educativo
    suspend fun updateContenido(contenido: ContenidoEducativoModel) {
        contenidoEducativoDao.update(contenido.toEntity())
    }

    // Eliminar un contenido educativo
    suspend fun deleteContenido(contenido: ContenidoEducativoModel) {
        contenidoEducativoDao.delete(contenido.toEntity())
    }

    // Eliminar todos los contenidos educativos
    suspend fun deleteAllContenidos() {
        contenidoEducativoDao.deleteAll()
    }

    // ======== MAPPERS ========

    private fun ContenidoEducativo.toDomain(): ContenidoEducativoModel = ContenidoEducativoModel(
        id = id,
        titulo = titulo,
        descripcion = descripcion,
        categoria = categoria,
        contenido = contenido,
        iconoUrl = iconoUrl
    )

    private fun ContenidoEducativoModel.toEntity(): ContenidoEducativo = ContenidoEducativo(
        id = id,
        titulo = titulo,
        descripcion = descripcion,
        categoria = categoria,
        contenido = contenido,
        iconoUrl = iconoUrl
    )
}
