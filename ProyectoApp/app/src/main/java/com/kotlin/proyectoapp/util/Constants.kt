package com.kotlin.proyectoapp.util

object Constants {
    // URLs de fuentes oficiales
    const val URL_JNE = "https://www.jne.gob.pe"
    const val URL_ONPE = "https://www.onpe.gob.pe"
    const val URL_CONGRESO = "https://www.congreso.gob.pe"
    const val URL_PODER_JUDICIAL = "https://www.pj.gob.pe"
    const val URL_INFOGOB = "https://infogob.com.pe"

    // Estados de proyectos
    const val ESTADO_APROBADO = "Aprobado"
    const val ESTADO_EN_TRAMITE = "En trámite"
    const val ESTADO_RECHAZADO = "Rechazado"

    // Estados de denuncias
    const val ESTADO_EN_PROCESO = "En proceso"
    const val ESTADO_ARCHIVADO = "Archivado"
    const val ESTADO_SENTENCIADO = "Sentenciado"

    // Tipos de denuncias
    const val TIPO_PENAL = "Penal"
    const val TIPO_CIVIL = "Civil"
    const val TIPO_ELECTORAL = "Electoral"

    // Cargos
    const val CARGO_PRESIDENCIA = "Presidencia"
    const val CARGO_CONGRESO = "Congreso"

    // Regiones del Perú
    val REGIONES = listOf(
        "Amazonas", "Áncash", "Apurímac", "Arequipa", "Ayacucho",
        "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huánuco",
        "Ica", "Junín", "La Libertad", "Lambayeque", "Lima",
        "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura",
        "Puno", "San Martín", "Tacna", "Tumbes", "Ucayali"
    )
}