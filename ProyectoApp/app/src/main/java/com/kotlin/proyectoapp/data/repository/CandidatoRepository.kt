package com.kotlin.proyectoapp.data.repository

import com.kotlin.proyectoapp.data.local.dao.CandidatoDao
import com.kotlin.proyectoapp.data.local.dao.DenunciaDao
import com.kotlin.proyectoapp.data.local.dao.ProyectoDao
import com.kotlin.proyectoapp.data.local.entities.CandidatoEntity
import com.kotlin.proyectoapp.data.local.entities.DenunciaEntity
import com.kotlin.proyectoapp.data.local.entities.ProyectoEntity
import com.kotlin.proyectoapp.domain.model.Candidato
import com.kotlin.proyectoapp.domain.model.Denuncia
import com.kotlin.proyectoapp.domain.model.Proyecto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CandidatoRepository(
    private val candidatoDao: CandidatoDao,
    private val proyectoDao: ProyectoDao,
    private val denunciaDao: DenunciaDao
) {

    fun getAllCandidatos(): Flow<List<Candidato>> {
        return candidatoDao.getCandidatosWithProyectosAndDenuncias().map { list ->
            list.map {
                it.candidato.toDomainModel(
                    proyectos = it.proyectos.map { p -> p.toDomainModel() },
                    denuncias = it.denuncias.map { d -> d.toDomainModel() }
                )
            }
        }
    }

    fun getCandidatoById(id: Int): Flow<Candidato?> = flow {
        val candidatoEntity = candidatoDao.getCandidatoById(id)
        if (candidatoEntity == null) {
            emit(null)
            return@flow
        }

        combine(
            proyectoDao.getProyectosByCandidato(id),
            denunciaDao.getDenunciasByCandidato(id)
        ) { proyectosList, denunciasList ->
            candidatoEntity.toDomainModel(
                proyectos = proyectosList.map { it.toDomainModel() },
                denuncias = denunciasList.map { it.toDomainModel() }
            )
        }.collect { emit(it) }
    }

    fun searchCandidatos(query: String): Flow<List<Candidato>> {
        return candidatoDao.searchCandidatos(query).map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    fun getCandidatosByCargo(cargo: String): Flow<List<Candidato>> {
        return candidatoDao.getCandidatosByCargo(cargo).map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    fun getCandidatosByPartido(partido: String): Flow<List<Candidato>> {
        return candidatoDao.getCandidatosByPartido(partido).map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    suspend fun insertCandidato(candidato: Candidato): Long {
        return candidatoDao.insert(candidato.toEntity())
    }

    suspend fun updateCandidato(candidato: Candidato) {
        candidatoDao.update(candidato.toEntity())
    }

    suspend fun deleteCandidato(candidato: Candidato) {
        candidatoDao.delete(candidato.toEntity())
    }

    // Mappers
    private fun CandidatoEntity.toDomainModel(
        proyectos: List<Proyecto> = emptyList(),
        denuncias: List<Denuncia> = emptyList()
    ) = Candidato(
        id = id,
        nombre = nombre,
        apellidos = apellidos,
        cargo = cargo,
        partido = partido,
        region = region,
        fotoUrl = fotoUrl,
        biografia = biografia,
        fechaNacimiento = fechaNacimiento,
        profesion = profesion,
        correo = correo,
        telefono = telefono,
        proyectos = proyectos,
        denuncias = denuncias
    )

    private fun ProyectoEntity.toDomainModel() = Proyecto(
        id = id,
        candidatoId = candidatoId,
        titulo = titulo,
        descripcion = descripcion,
        fecha = fecha,
        estado = estado,
        urlFuente = urlFuente
    )

    private fun DenunciaEntity.toDomainModel() = Denuncia(
        id = id,
        candidatoId = candidatoId,
        tipo = tipo,
        descripcion = descripcion,
        fecha = fecha,
        estado = estado,
        urlFuente = urlFuente
    )

    private fun Candidato.toEntity() = CandidatoEntity(
        id = id,
        nombre = nombre,
        apellidos = apellidos,
        cargo = cargo,
        partido = partido,
        region = region,
        fotoUrl = fotoUrl,
        biografia = biografia,
        fechaNacimiento = fechaNacimiento,
        profesion = profesion,
        correo = correo,
        telefono = telefono
    )
}