package com.proyecto.project01_a.data.model

data class Candidato(
    val id: String,
    val nombre: String,
    val partido: String,
    val cargoPostula: String,
    val fotoUrl: String,
    val edad: Int,
    val profesion: String,
    val biografia: String,
    val propuestas: List<Propuesta>,
    val denuncias: List<Denuncia>,
    val historial: List<CargoAnterior>,
    val financiamiento: Financiamiento,
    val redesSociales: RedesSociales
)

data class Propuesta(
    val categoria: String,
    val titulo: String,
    val descripcion: String,
    val prioridad: String // Alta, Media, Baja
)

data class Denuncia(
    val tipo: String,
    val descripcion: String,
    val año: Int,
    val estado: String, // Archivado, En proceso, Sentenciado
    val fuenteUrl: String
)

data class CargoAnterior(
    val cargo: String,
    val institucion: String,
    val periodo: String,
    val descripcion: String
)

data class Financiamiento(
    val montoDeclared: String,
    val fuentesPrincipales: List<String>,
    val transparencia: String // Alta, Media, Baja
)

data class RedesSociales(
    val facebook: String?,
    val twitter: String?,
    val instagram: String?,
    val webOficial: String?
)

data class Partido(
    val id: String,
    val nombre: String,
    val nombreCorto: String,
    val logoUrl: String,
    val fundacion: Int,
    val ideologia: String,
    val descripcion: String,
    val lider: String,
    val miembrosDestacados: List<String>,
    val propuestasGenerales: List<String>,
    val webOficial: String?
)

data class Noticia(
    val id: String,
    val titulo: String,
    val descripcion: String,
    val fuente: String,
    val fecha: String,
    val imagenUrl: String,
    val url: String,
    val categoria: String // Política, Economía, Social
)

data class ContenidoEducativo(
    val id: String,
    val titulo: String,
    val descripcion: String,
    val categoria: String,
    val contenido: String,
    val iconoUrl: String?
)

data class CandidatoCongreso(
    val id: String,
    val nombre: String,
    val partido: String,
    val region: String,
    val fotoUrl: String,
    val edad: Int,
    val profesion: String,
    val propuestas: List<String>,
    val historial: String
)