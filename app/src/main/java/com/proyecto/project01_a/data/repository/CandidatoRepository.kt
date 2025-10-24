package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.local.dao.CandidatoDao
import com.proyecto.project01_a.data.local.entities.Candidato
import com.proyecto.project01_a.data.local.entities.Partido
import com.proyecto.project01_a.data.local.entities.Propuesta
import com.proyecto.project01_a.data.local.entities.Denuncia
import com.proyecto.project01_a.data.local.entities.CargoAnterior
import com.proyecto.project01_a.data.local.entities.Financiamiento
import com.proyecto.project01_a.data.local.entities.RedesSociales
import com.proyecto.project01_a.data.local.relations.CandidatoRelations
import com.proyecto.project01_a.domain.model.CandidatoModel
import com.proyecto.project01_a.domain.model.PartidoModel
import com.proyecto.project01_a.domain.model.PropuestaModel
import com.proyecto.project01_a.domain.model.DenunciaModel
import com.proyecto.project01_a.domain.model.CargoAnteriorModel
import com.proyecto.project01_a.domain.model.FinanciamientoModel
import com.proyecto.project01_a.domain.model.RedesSocialesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CandidatoRepository(
    private val candidatoDao: CandidatoDao
) {

    fun getAllCandidatos(): Flow<List<CandidatoModel>> {
        return candidatoDao.getAllCandidatos().map { list ->
            list.map { it.toDomainSimple() }
        }
    }

    fun getAllCandidatosRelations(): Flow<List<CandidatoModel>> {
        return candidatoDao.getAllCandidatosRelations().map { list ->
            list.map { it.toDomain() }
        }
    }

    fun getCandidatoRelationsById(id: Int): Flow<CandidatoModel> {
        return candidatoDao.getCandidatoRelationsById(id).map { it.toDomain() }
    }

    suspend fun insertCandidato(candidato: CandidatoModel): Long {
        return candidatoDao.insert(candidato.toEntity())
    }

    suspend fun insertAllCandidatos(candidatos: List<CandidatoModel>) {
        candidatoDao.insertAll(candidatos.map { it.toEntity() })
    }

    suspend fun updateCandidato(candidato: CandidatoModel) {
        candidatoDao.update(candidato.toEntity())
    }

    suspend fun deleteCandidato(candidato: CandidatoModel) {
        candidatoDao.delete(candidato.toEntity())
    }

    suspend fun deleteAllCandidatos() {
        candidatoDao.deleteAll()
    }
    private fun CandidatoRelations.toDomain(): CandidatoModel = CandidatoModel(
        id = candidato.id,
        nombre = candidato.nombre,
        cargoPostula = candidato.cargoPostula,
        fotoUrl = candidato.fotoUrl,
        edad = candidato.edad,
        profesion = candidato.profesion,
        biografia = candidato.biografia,
        partido = partido.toDomain(),
        propuestas = propuestas.map { it.toDomain() },
        denuncias = denuncias.map { it.toDomain() },
        historial = cargos.map { it.toDomain() },
        financiamiento = financiamiento?.toDomain(),
        redesSociales = redesSociales?.toDomain()
    )

    private fun Candidato.toDomainSimple(): CandidatoModel = CandidatoModel(
        id = id,
        nombre = nombre,
        cargoPostula = cargoPostula,
        fotoUrl = fotoUrl,
        edad = edad,
        profesion = profesion,
        biografia = biografia,
        partido = PartidoModel(
            id = partidoId,
            nombre = "",
            nombreCorto = "",
            logoUrl = "",
            fundacion = 0,
            ideologia = "",
            descripcion = "",
            lider = "",
            miembrosDestacados = emptyList(),
            propuestasGenerales = emptyList(),
            webOficial = null
        )
    )

    private fun CandidatoModel.toEntity(): Candidato = Candidato(
        id = id,
        nombre = nombre,
        partidoId = partido.id,
        cargoPostula = cargoPostula,
        fotoUrl = fotoUrl,
        edad = edad,
        profesion = profesion,
        biografia = biografia
    )

    private fun Partido.toDomain(): PartidoModel = PartidoModel(
        id = id,
        nombre = nombre,
        nombreCorto = nombreCorto,
        logoUrl = logoUrl,
        fundacion = fundacion,
        ideologia = ideologia,
        descripcion = descripcion,
        lider = lider,
        miembrosDestacados = emptyList(),
        propuestasGenerales = emptyList(),
        webOficial = webOficial
    )

    private fun Propuesta.toDomain(): PropuestaModel = PropuestaModel(
        id = id,
        candidatoId = candidatoId,
        categoria = categoria,
        titulo = titulo,
        descripcion = descripcion,
        prioridad = prioridad
    )


    private fun Denuncia.toDomain(): DenunciaModel = DenunciaModel(
        tipo = tipo,
        descripcion = descripcion,
        año = año,
        estado = estado,
        fuenteUrl = fuenteUrl
    )

    private fun CargoAnterior.toDomain(): CargoAnteriorModel = CargoAnteriorModel(
        cargo = cargo,
        institucion = institucion,
        periodo = periodo,
        descripcion = descripcion
    )

    private fun Financiamiento.toDomain(): FinanciamientoModel = FinanciamientoModel(
        montoDeclared = montoDeclared,
        fuentesPrincipales = emptyList(),
        transparencia = transparencia
    )

    private fun RedesSociales.toDomain(): RedesSocialesModel = RedesSocialesModel(
        facebook = facebook,
        twitter = twitter,
        instagram = instagram,
        webOficial = webOficial
    )
}
