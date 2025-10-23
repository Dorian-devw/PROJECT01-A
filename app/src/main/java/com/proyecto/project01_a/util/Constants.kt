package com.proyecto.project01_a.util

object Constants {

    const val DATABASE_NAME = "elecciones_db"

    const val TABLE_PARTIDOS = "partidos"
    const val TABLE_CANDIDATOS = "candidatos"
    const val TABLE_PROPUESTAS = "propuestas"
    const val TABLE_DENUNCIAS = "denuncias"

    const val URL_JNE = "https://www.jne.gob.pe"
    const val URL_ONPE = "https://www.onpe.gob.pe"
    const val URL_CONGRESO = "https://www.congreso.gob.pe"
    const val URL_PODER_JUDICIAL = "https://www.pj.gob.pe"
    const val URL_INFOGOB = "https://infogob.jne.gob.pe"

    const val ESTADO_EN_PROCESO = "En proceso"
    const val ESTADO_ARCHIVADO = "Archivado"
    const val ESTADO_SENTENCIADO = "Sentenciado"

    const val TIPO_PENAL = "Penal"
    const val TIPO_CIVIL = "Civil"
    const val TIPO_ELECTORAL = "Electoral"

    const val CARGO_PRESIDENCIA = "Presidencia"
    const val CARGO_CONGRESO = "Congreso"
    const val CARGO_VICEPRESIDENCIA = "Vicepresidencia"
    const val CARGO_MINISTERIO = "Ministerio"

    const val PRIORIDAD_ALTA = "Alta"
    const val PRIORIDAD_MEDIA = "Media"
    const val PRIORIDAD_BAJA = "Baja"

    val REGIONES = listOf(
        "Amazonas", "Áncash", "Apurímac", "Arequipa", "Ayacucho",
        "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huánuco",
        "Ica", "Junín", "La Libertad", "Lambayeque", "Lima",
        "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura",
        "Puno", "San Martín", "Tacna", "Tumbes", "Ucayali"
    )
}
