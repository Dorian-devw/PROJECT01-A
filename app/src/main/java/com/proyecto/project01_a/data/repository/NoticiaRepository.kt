package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.NoticiaDao
import com.proyecto.project01_a.data.local.entities.Noticia
import com.proyecto.project01_a.domain.model.NoticiaModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoticiaRepository(
    private val noticiaDao: NoticiaDao
) {

    // Obtener todas las noticias ordenadas por fecha (más recientes primero)
    fun getAllNoticias(): Flow<List<NoticiaModel>> {
        return noticiaDao.getAllNoticias().map { list ->
            list.map { it.toDomain() }
        }
    }

    // Insertar una noticia
    suspend fun insertNoticia(noticia: NoticiaModel): Long {
        return noticiaDao.insert(noticia.toEntity())
    }

    // Insertar varias noticias
    suspend fun insertAllNoticias(noticias: List<NoticiaModel>) {
        noticiaDao.insertAll(noticias.map { it.toEntity() })
    }

    // Actualizar una noticia
    suspend fun updateNoticia(noticia: NoticiaModel) {
        noticiaDao.update(noticia.toEntity())
    }

    // Eliminar una noticia
    suspend fun deleteNoticia(noticia: NoticiaModel) {
        noticiaDao.delete(noticia.toEntity())
    }

    // Eliminar todas las noticias
    suspend fun deleteAllNoticias() {
        noticiaDao.deleteAll()
    }

    // ======== MAPPERS ========

    private fun Noticia.toDomain(): NoticiaModel = NoticiaModel(
        id = id,
        titulo = titulo,
        descripcion = descripcion,
        fuente = fuente,
        fecha = fecha,
        imagenUrl = imagenUrl,
        url = url,
        categoria = categoria
    )

    private fun NoticiaModel.toEntity(): Noticia = Noticia(
        id = id,
        titulo = titulo,
        descripcion = descripcion,
        fuente = fuente,
        fecha = fecha,
        imagenUrl = imagenUrl,
        url = url,
        categoria = categoria
    )
}
