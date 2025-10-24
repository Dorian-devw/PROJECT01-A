package com.kotlin.proyectoapp.util

import com.kotlin.proyectoapp.R
import com.kotlin.proyectoapp.data.local.entities.CandidatoEntity
import com.kotlin.proyectoapp.data.local.entities.DenunciaEntity
import com.kotlin.proyectoapp.data.local.entities.ProyectoEntity

object DataSeeder { // datos simulados para la app

    fun getCandidatosSample(): List<CandidatoEntity> {
        return listOf(
            CandidatoEntity(
                id = 1,
                nombre = "Alfredo",
                apellidos = "Barnechea García",
                cargo = "Presidencia",
                partido = "Acción Popular",
                region = "Lima",
                // corregido el problema de los url de imagenes xd
                fotoUrl = "android.resource://com.kotlin.proyectoapp/" + R.drawable.candidato_1,
                biografia = "Escritor, periodista, conductor de televisión y político peruano. Fue candidato presidencial por el Partido" +
                        " Acción Popular a las elecciones generales de Perú que se llevaron a cabo el 10 de abril de 2016, en las cuales" +
                        " quedó en el cuarto lugar",
                fechaNacimiento = "19/04/1952",
                profesion = "Político",
                correo = "abernechea@accionpopular.pe",
                telefono = "+51 925 810 757"
            ),
            CandidatoEntity(
                id = 2,
                nombre = "Víctor",
                apellidos = "García Belaúnde",
                cargo = "Presidencia",
                partido = "Acción Popular",
                region = "Arequipa",
                fotoUrl = "android.resource://com.kotlin.proyectoapp/" + R.drawable.candidato_2,
                biografia = "Abogado, escritor y político peruano. Miembro histórico del partido Acción Popular, fue congresista de la" +
                        " república durante tres periodos (2006-2019) y diputado en dos periodos (1985-1992)",
                fechaNacimiento = "06/06/1949",
                profesion = "Abogado",
                correo = "vgarcia@accionpopular.pe",
                telefono = "+51 901 715 326"
            ),
            CandidatoEntity(
                id = 3,
                nombre = "Julio",
                apellidos = "Chávez Chiong",
                cargo = "Presidencia",
                partido = "Acción Popular",
                region = "Lima",
                fotoUrl = "https://upload.wikimedia.org/wikipedia/commons/e/e9/Julio_Chavez_Accion_Popular.jpg",
                biografia = "Político y abogado peruano. Fue el alcalde distrital de San Martín de Porres para el periodo 2019-2022." +
                        "Actualmente es presidente de Acción Popular para el periodo 2024-2028.",
                fechaNacimiento = "22/07/1981",
                profesion = "Abogado",
                correo = "jchavez@accionpopular.pe",
                telefono = "+51 967 806 120"
            ),
            CandidatoEntity(
                id = 4,
                nombre = "Pedro",
                apellidos = "Martínez Talavera",
                cargo = "Presidencia",
                partido = "Acción Popular",
                region = "Arequipa",
                fotoUrl = "android.resource://com.kotlin.proyectoapp/" + R.drawable.candidato_4,
                biografia = "Administrador y político peruano. Es congresista de la república por Arequipa para el periodo 2021-2026. " +
                        "Fue alcalde del distrito de Mariano Melgar desde 2015 hasta 2018 y regidor municipal en 2007.",
                fechaNacimiento = "27/04/1966",
                profesion = "Abogado",
                correo = "pmartinez@accionapopular.pe",
                telefono = "+51 968 925 437"
            ),
            CandidatoEntity(
                id = 5,
                nombre = "Higinio",
                apellidos = "Torres",
                cargo = "Presidencia",
                partido = "Acción Popular",
                region = "Ancash",
                fotoUrl = "android.resource://com.kotlin.proyectoapp/" + R.drawable.candidato_5,
                biografia = "Administrador y político peruano.",
                fechaNacimiento = "28/02/1978",
                profesion = "Administrador",
                correo = "htorres@accionapopular.pe",
                telefono = "+51 955 444 333"
            ),
            CandidatoEntity(
                id = 6,
                nombre = "Keiko",
                apellidos = "Fujimori Higuchi",
                cargo = "Presidencia",
                partido = "Fuerza Popular",
                region = "Lima",
                fotoUrl = "android.resource://com.kotlin.proyectoapp/" + R.drawable.candidato_6,
                biografia = "administradora y política peruana. Es líder del partido Fuerza Popular y ha sido tres veces candidata presidencial" +
                        " con presencia en la segunda vuelta en todas las ocasiones",
                fechaNacimiento = "25/05/1975",
                profesion = "Administradora",
                correo = "htorres@accionapopular.pe",
                telefono = "+51 917 154 380"
            ),
            CandidatoEntity(
                id = 7,
                nombre = "Pablo",
                apellidos = "López-Chau Nava",
                cargo = "Presidencia",
                partido = "Ahora Nación",
                region = "Lima",
                fotoUrl = "https://upload.wikimedia.org/wikipedia/commons/f/f7/Alfonso_L%C3%B3pez-Chau.jpg",
                biografia = "académico, economista y político peruano que ejerció como el rector de la Universidad Nacional de Ingeniería. " +
                        "Previamente fue director del Banco de Reserva del Perú de 2006 a 2012." +
                        "\n" +
                        "Es el actual líder del partido político de centroizquierda Ahora Nación que participará en las elecciones generales de Perú de 2026.",
                fechaNacimiento = "17/07/1950",
                profesion = "Administradora",
                correo = "lopez-chau@ahoranacion.pe",
                telefono = "+51 917 154 380"
            ),
            CandidatoEntity(
                id = 8,
                nombre = "Cesar",
                apellidos = "Acuña Peralta",
                cargo = "Presidencia",
                partido = "Alianza para el Progreso",
                region = "Lima",
                fotoUrl = "https://upload.wikimedia.org/wikipedia/commons/b/bf/C%C3%A9sar_Acu%C3%B1a_Peralta.jpg",
                biografia = "Ingeniero químico, empresario y político peruano. Líder y fundador del partido Alianza " +
                        "para el Progreso, fue gobernador regional de La Libertad desde el 1 de enero del 2023 hasta " +
                        "el 13 de octubre de 2025, cargo que ejerció anteriormente en 2015. Fue también alcalde de la " +
                        "provincia de Trujillo en 2 ocasiones y congresista de la república durante 2 periodos parlamentarios." +
                        " Es propietario de la Universidad César Vallejo y la Universidad Señor de Sipán.",
                fechaNacimiento = "10/08/1952",
                profesion = "Empresario",
                correo = "cesaracuña@alianzaporelprogreso.pe",
                telefono = "+51 637 025 884"
            ),
            CandidatoEntity(
                id = 9,
                nombre = "Phillip",
                apellidos = "Butters Rivadeneira",
                cargo = "Presidencia",
                partido = "Avanza País",
                region = "Lima",
                fotoUrl = "android.resource://com.kotlin.proyectoapp/" + R.drawable.candidato_9,
                biografia = "Presentador de televisión, locutor de radio, empresario, político y escritor peruano.Es fundador de la emisora" +
                        " peruana PBO Radio y conocido por conducir el programa Combutters, que se emitió originalmente en Willax Televisión" +
                        " entre los años 2017 y 2024.",
                fechaNacimiento = "10/08/1952",
                profesion = "Periodista",
                correo = "Pbutters@avanzapais.pe",
                telefono = "+51 637 025 884"
            ),
            CandidatoEntity(
                id = 10,
                nombre = "César",
                apellidos = "Combina Salvatierra",
                cargo = "Presidencia",
                partido = "Avanza País",
                region = "Lima",
                fotoUrl = "android.resource://com.kotlin.proyectoapp/" + R.drawable.candidato_10,
                biografia = "Antropólogo, columnista y político peruano. Fue congresista de la república por Junín durante el periodo 2020-2021.",
                fechaNacimiento = "03/11/1987",
                profesion = "Antropólogo",
                correo = "ccombina@avanzapais.pe",
                telefono = "+51 637 025 884"
            ),
        )
    }

    fun getProyectosSample(): List<ProyectoEntity> {
        return listOf(
            ProyectoEntity(
                id = 1,
                candidatoId = 1,
                titulo = "Ley de Reforma del Sistema Judicial",
                descripcion = "Propuesta para modernizar y hacer más eficiente el sistema de justicia en el Perú.",
                fecha = "2024-03-15",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/001"
            ),
            ProyectoEntity(
                id = 2,
                candidatoId = 1,
                titulo = "Ley de Transparencia Electoral",
                descripcion = "Proyecto para fortalecer los mecanismos de fiscalización en procesos electorales.",
                fecha = "2024-01-20",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/002"
            ),
            ProyectoEntity(
                id = 3,
                candidatoId = 2,
                titulo = "Proyecto de Desarrollo Económico Regional",
                descripcion = "Iniciativa para promover la inversión pública en regiones del sur del país.",
                fecha = "2023-11-10",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/003"
            ),
            ProyectoEntity(
                id = 4,
                candidatoId = 3,
                titulo = "Ley de Protección Ambiental",
                descripcion = "Norma para regular la explotación de recursos naturales y proteger ecosistemas.",
                fecha = "2024-02-05",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/004"
            ),
            ProyectoEntity(
                id = 5,
                candidatoId = 5,
                titulo = "Reforma del Sistema de Salud Pública",
                descripcion = "Propuesta integral para mejorar el acceso y calidad de servicios de salud.",
                fecha = "2023-12-01",
                estado = "Rechazado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/005"
            ),
            ProyectoEntity(
                id = 6,
                candidatoId = 6,
                titulo = "Reforma del Sistema Educativo",
                descripcion = "Propuesta nacional para mejorar el acceso y calidad de servicios de educación en todo el Perú.",
                fecha = "2023-12-01",
                estado = "Rechazado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/006"
            ),
            ProyectoEntity(
                id = 7,
                candidatoId = 2,
                titulo = "Ley de Impulso a la Innovación Tecnológica",
                descripcion = "Iniciativa que fomenta la creación de startups tecnológicas mediante incentivos tributarios.",
                fecha = "2024-03-22",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/007"
            ),
            ProyectoEntity(
                id = 8,
                candidatoId = 4,
                titulo = "Programa Nacional de Vivienda Rural",
                descripcion = "Proyecto para reducir el déficit habitacional en comunidades rurales con materiales sostenibles.",
                fecha = "2023-09-18",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/008"
            ),
            ProyectoEntity(
                id = 9,
                candidatoId = 5,
                titulo = "Ley de Igualdad Salarial entre Hombres y Mujeres",
                descripcion = "Propuesta para garantizar la equidad salarial en el sector público y privado.",
                fecha = "2024-01-10",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/009"
            ),
            ProyectoEntity(
                id = 10,
                candidatoId = 3,
                titulo = "Plan Nacional de Electrificación Rural",
                descripcion = "Iniciativa para llevar energía eléctrica a zonas aisladas mediante fuentes renovables.",
                fecha = "2023-10-05",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/010"
            ),
            ProyectoEntity(
                id = 11,
                candidatoId = 8,
                titulo = "Ley de Ciberseguridad Nacional",
                descripcion = "Norma para proteger la infraestructura digital del país frente a amenazas informáticas.",
                fecha = "2024-04-01",
                estado = "En revisión",
                urlFuente = "https://www.congreso.gob.pe/proyectos/011"
            ),
            ProyectoEntity(
                id = 12,
                candidatoId = 4,
                titulo = "Programa de Alfabetización Digital",
                descripcion = "Propuesta para capacitar a ciudadanos en el uso de herramientas digitales básicas.",
                fecha = "2024-02-10",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/012"
            ),
            ProyectoEntity(
                id = 13,
                candidatoId = 2,
                titulo = "Reforma de Transporte Público Nacional",
                descripcion = "Proyecto para unificar la regulación del transporte urbano y mejorar la movilidad sostenible.",
                fecha = "2024-01-28",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/013"
            ),
            ProyectoEntity(
                id = 14,
                candidatoId = 6,
                titulo = "Ley de Protección del Patrimonio Cultural",
                descripcion = "Medida para sancionar el tráfico ilegal y deterioro del patrimonio arqueológico nacional.",
                fecha = "2023-12-14",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/014"
            ),
            ProyectoEntity(
                id = 15,
                candidatoId = 8,
                titulo = "Ley de Fomento a la Agricultura Sostenible",
                descripcion = "Iniciativa que promueve el uso responsable del agua y fertilizantes ecológicos.",
                fecha = "2023-11-25",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/015"
            ),
            ProyectoEntity(
                id = 16,
                candidatoId = 3,
                titulo = "Ley de Protección Animal",
                descripcion = "Proyecto para endurecer sanciones contra el maltrato animal y promover adopciones responsables.",
                fecha = "2024-03-10",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/016"
            ),
            ProyectoEntity(
                id = 17,
                candidatoId = 2,
                titulo = "Ley de Fomento del Turismo Interno",
                descripcion = "Medida para incentivar el turismo nacional a través de feriados largos y descuentos tributarios.",
                fecha = "2024-04-02",
                estado = "En revisión",
                urlFuente = "https://www.congreso.gob.pe/proyectos/017"
            ),
            ProyectoEntity(
                id = 18,
                candidatoId = 1,
                titulo = "Reforma del Sistema de Pensiones",
                descripcion = "Propuesta para unificar los sistemas público y privado de pensiones garantizando la sostenibilidad.",
                fecha = "2023-12-30",
                estado = "Rechazado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/018"
            ),
            ProyectoEntity(
                id = 19,
                candidatoId = 6,
                titulo = "Ley de Protección de Datos Personales",
                descripcion = "Actualización normativa para proteger la información digital de los ciudadanos.",
                fecha = "2024-03-01",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/019"
            ),
            ProyectoEntity(
                id = 20,
                candidatoId = 5,
                titulo = "Plan Nacional contra la Desnutrición Infantil",
                descripcion = "Iniciativa para reducir los índices de desnutrición en menores de 5 años en zonas rurales.",
                fecha = "2023-09-10",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/020"
            ),
            ProyectoEntity(
                id = 21,
                candidatoId = 2,
                titulo = "Ley de Promoción del Empleo Juvenil",
                descripcion = "Proyecto que incentiva la contratación de jóvenes recién egresados con beneficios tributarios.",
                fecha = "2024-02-22",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/021"
            ),
            ProyectoEntity(
                id = 22,
                candidatoId = 3,
                titulo = "Ley de Acceso al Internet Gratuito",
                descripcion = "Iniciativa para garantizar conectividad gratuita en instituciones educativas y plazas públicas.",
                fecha = "2024-01-11",
                estado = "En revisión",
                urlFuente = "https://www.congreso.gob.pe/proyectos/022"
            ),
            ProyectoEntity(
                id = 23,
                candidatoId = 4,
                titulo = "Ley de Apoyo a Emprendedores Locales",
                descripcion = "Propuesta que establece créditos y capacitaciones para microempresas peruanas.",
                fecha = "2023-11-05",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/023"
            ),
            ProyectoEntity(
                id = 24,
                candidatoId = 6,
                titulo = "Ley de Reforma del Sistema Tributario",
                descripcion = "Iniciativa que busca simplificar los tributos y ampliar la base de contribuyentes.",
                fecha = "2023-10-21",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/024"
            ),
            ProyectoEntity(
                id = 25,
                candidatoId = 1,
                titulo = "Ley de Seguridad Ciudadana Integral",
                descripcion = "Norma que propone la coordinación entre municipalidades y PNP para combatir la delincuencia.",
                fecha = "2023-12-15",
                estado = "En revisión",
                urlFuente = "https://www.congreso.gob.pe/proyectos/025"
            ),
            ProyectoEntity(
                id = 26,
                candidatoId = 2,
                titulo = "Ley de Inclusión Financiera",
                descripcion = "Propuesta para expandir los servicios bancarios digitales en comunidades rurales.",
                fecha = "2024-03-07",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/026"
            ),
            ProyectoEntity(
                id = 27,
                candidatoId = 4,
                titulo = "Ley de Transporte Sostenible",
                descripcion = "Norma para promover el uso de vehículos eléctricos y transporte no motorizado.",
                fecha = "2023-12-12",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/027"
            ),
            ProyectoEntity(
                id = 28,
                candidatoId = 3,
                titulo = "Ley de Fomento a la Ciencia y Tecnología",
                descripcion = "Proyecto para fortalecer la investigación científica mediante becas e infraestructura.",
                fecha = "2024-01-08",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/028"
            ),
            ProyectoEntity(
                id = 29,
                candidatoId = 5,
                titulo = "Ley de Energías Renovables",
                descripcion = "Iniciativa que impulsa la inversión en energía solar, eólica y geotérmica.",
                fecha = "2023-10-18",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/029"
            ),
            ProyectoEntity(
                id = 30,
                candidatoId = 6,
                titulo = "Ley de Reforma Laboral",
                descripcion = "Propuesta para modernizar los derechos laborales y flexibilizar la contratación.",
                fecha = "2024-02-03",
                estado = "Rechazado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/030"
            ),
            ProyectoEntity(
                id = 31,
                candidatoId = 4,
                titulo = "Ley de Seguridad Alimentaria",
                descripcion = "Proyecto para garantizar el acceso a alimentos saludables y sostenibles.",
                fecha = "2024-01-25",
                estado = "En revisión",
                urlFuente = "https://www.congreso.gob.pe/proyectos/031"
            ),
            ProyectoEntity(
                id = 32,
                candidatoId = 2,
                titulo = "Ley de Apoyo a la Mujer Emprendedora",
                descripcion = "Iniciativa que promueve el acceso a financiamiento y capacitación para mujeres emprendedoras.",
                fecha = "2024-03-17",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/032"
            ),
            ProyectoEntity(
                id = 33,
                candidatoId = 1,
                titulo = "Ley de Protección del Consumidor Digital",
                descripcion = "Norma para regular las transacciones electrónicas y proteger a los usuarios de fraudes.",
                fecha = "2024-04-05",
                estado = "En trámite",
                urlFuente = "https://www.congreso.gob.pe/proyectos/033"
            ),
            ProyectoEntity(
                id = 34,
                candidatoId = 3,
                titulo = "Ley de Desarrollo Rural Sostenible",
                descripcion = "Proyecto que busca fortalecer la producción agrícola y reducir la migración rural-urbana.",
                fecha = "2023-09-25",
                estado = "En revisión",
                urlFuente = "https://www.congreso.gob.pe/proyectos/034"
            ),
            ProyectoEntity(
                id = 35,
                candidatoId = 5,
                titulo = "Ley de Inclusión para Personas con Discapacidad",
                descripcion = "Propuesta para mejorar el acceso laboral y educativo de personas con discapacidad.",
                fecha = "2024-02-28",
                estado = "Aprobado",
                urlFuente = "https://www.congreso.gob.pe/proyectos/035"
            ),
            ProyectoEntity(
                id = 36,
                candidatoId = 6,
                titulo = "Ley de Modernización del Estado",
                descripcion = "Proyecto que promueve la digitalización de los servicios públicos y la transparencia administrativa.",
                fecha = "2024-03-12",
                estado = "En revisión",
                urlFuente = "https://www.congreso.gob.pe/proyectos/036"
            )
        )
    }

    fun getDenunciasSample(): List<DenunciaEntity> {
        return listOf(
            DenunciaEntity(
                id = 1,
                candidatoId = 2,
                tipo = "Penal",
                descripcion = "Investigación por presunto delito de corrupción en contratación pública.",
                fecha = "2022-06-15",
                estado = "En proceso",
                urlFuente = "https://www.pj.gob.pe/casos/001"
            ),
            DenunciaEntity(
                id = 2,
                candidatoId = 4,
                tipo = "Electoral",
                descripcion = "Denuncia por irregularidades en financiamiento de campaña electoral.",
                fecha = "2023-08-20",
                estado = "Archivado",
                urlFuente = "https://www.jne.gob.pe/denuncias/002"
            ),
            DenunciaEntity(
                id = 3,
                candidatoId = 2,
                tipo = "Civil",
                descripcion = "Proceso civil por incumplimiento de contrato en proyecto municipal.",
                fecha = "2021-03-10",
                estado = "Sentenciado",
                urlFuente = "https://www.pj.gob.pe/casos/003"
            ),

        )
    }
}