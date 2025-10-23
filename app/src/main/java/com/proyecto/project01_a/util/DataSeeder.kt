package com.proyecto.project01_a.util

import com.proyecto.project01_a.data.local.entities.*

object DataSeeder {

    fun getPartidosSample(): List<Partido> = listOf(
        Partido(
            id = 1,
            nombre = "Partido Democrático",
            nombreCorto = "PD",
            logoUrl = "https://example.com/logo_pd.png",
            fundacion = 1995,
            ideologia = "Progresista",
            descripcion = "Partido enfocado en derechos sociales y transparencia.",
            lider = "María López",
            webOficial = "https://partidodemocratico.pe"
        ),
        Partido(
            id = 2,
            nombre = "Alianza Nacional",
            nombreCorto = "AN",
            logoUrl = "https://example.com/logo_an.png",
            fundacion = 2001,
            ideologia = "Conservadora",
            descripcion = "Promueve el desarrollo económico sostenible.",
            lider = "Juan Pérez",
            webOficial = "https://alianzanacional.pe"
        )
    )

    fun getCandidatosSample(): List<Candidato> = listOf(
        Candidato(
            id = 1,
            nombre = "María González",
            partidoId = 1,
            cargoPostula = Constants.CARGO_PRESIDENCIA,
            fotoUrl = "https://example.com/maria.jpg",
            edad = 45,
            profesion = "Abogada",
            biografia = "Abogada con experiencia en derecho constitucional y políticas públicas."
        ),
        Candidato(
            id = 2,
            nombre = "Juan Torres",
            partidoId = 2,
            cargoPostula = Constants.CARGO_CONGRESO,
            fotoUrl = "https://example.com/juan.jpg",
            edad = 38,
            profesion = "Economista",
            biografia = "Economista con enfoque en desarrollo regional y gestión pública."
        )
    )

    fun getPropuestasSample(): List<Propuesta> = listOf(
        Propuesta(
            id = 1,
            candidatoId = 1,
            categoria = "Educación",
            titulo = "Mejorar el acceso a la educación superior",
            descripcion = "Incrementar becas, infraestructura y programas de intercambio académico.",
            prioridad = Constants.PRIORIDAD_ALTA
        ),
        Propuesta(
            id = 2,
            candidatoId = 2,
            categoria = "Economía",
            titulo = "Reducir impuestos a pequeñas empresas",
            descripcion = "Incentivar la formalización y apoyar el crecimiento de las pymes rurales.",
            prioridad = Constants.PRIORIDAD_MEDIA
        )
    )

    fun getDenunciasSample(): List<Denuncia> = listOf(
        Denuncia(
            id = 1,
            candidatoId = 2,
            tipo = Constants.TIPO_PENAL,
            descripcion = "Presunta malversación de fondos públicos durante su gestión municipal.",
            año = 2020,
            estado = Constants.ESTADO_EN_PROCESO,
            fuenteUrl = "https://www.pj.gob.pe/casos/juan-torres"
        )
    )
}
