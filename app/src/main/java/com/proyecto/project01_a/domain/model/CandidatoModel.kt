package com.proyecto.project01_a.domain.model

data class CandidatoModel(
    val id: Int = 0,
    val nombre: String,
    val cargoPostula: String,
    val fotoUrl: String,
    val edad: Int,
    val profesion: String,
    val biografia: String,
    val partido: PartidoModel,
    val propuestas: List<PropuestaModel> = emptyList(),
    val denuncias: List<DenunciaModel> = emptyList(),
    val historial: List<CargoAnteriorModel> = emptyList(),
    val financiamiento: FinanciamientoModel? = null,
    val redesSociales: RedesSocialesModel? = null
)
