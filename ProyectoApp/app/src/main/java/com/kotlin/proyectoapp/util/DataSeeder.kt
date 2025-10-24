package com.kotlin.proyectoapp.util

import com.kotlin.proyectoapp.data.local.entities.CandidatoEntity
import com.kotlin.proyectoapp.data.local.entities.DenunciaEntity
import com.kotlin.proyectoapp.data.local.entities.ProyectoEntity

object DataSeeder {

    fun getCandidatosSample(): List<CandidatoEntity> {
        return listOf(
            CandidatoEntity(
                id = 1,
                nombre = "María",
                apellidos = "González Pérez",
                cargo = "Presidencia",
                partido = "Partido Democrático",
                region = "Lima",
                fotoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Melinda_Gates_2013.jpg/800px-Melinda_Gates_2013.jpg",
                biografia = "Abogada con 20 años de experiencia en derecho constitucional. Ex ministra de Justicia.",
                fechaNacimiento = "15/03/1975",
                profesion = "Abogada",
                correo = "mgonzalez@partidodemo.pe",
                telefono = "+51 999 888 767"
            ),
            CandidatoEntity(
                id = 2,
                nombre = "Juan",
                apellidos = "Rodríguez Silva",
                cargo = "Congreso",
                partido = "Frente Nacional",
                region = "Arequipa",
                fotoUrl = "https://upload.wikimedia.org/wikipedia/commons/8/8d/President_Barack_Obama.jpg",
                biografia = "Economista, ex rector universitario. Especialista en políticas públicas.",
                fechaNacimiento = "22/07/1968",
                profesion = "Economista",
                correo = "jrodriguez@frentenacional.pe",
                telefono = "+51 988 777 666"
            ),
            CandidatoEntity(
                id = 3,
                nombre = "Ana",
                apellidos = "Martínez Campos",
                cargo = "Congreso",
                partido = "Partido Verde",
                region = "Cusco",
                fotoUrl = "https://upload.wikimedia.org/wikipedia/commons/e/e8/Michelle_Obama_in_2013.jpg",
                biografia = "Ingeniera ambiental, activista por el desarrollo sostenible.",
                fechaNacimiento = "10/11/1982",
                profesion = "Ingeniera Ambiental",
                correo = "amartinez@partidoverde.pe",
                telefono = "+51 977 666 555"
            ),
            CandidatoEntity(
                id = 4,
                nombre = "Carlos",
                apellidos = "López Vargas",
                cargo = "Presidencia",
                partido = "Alianza Popular",
                region = "Lima",
                fotoUrl = "https://upload.wikimedia.org/wikipedia/commons/a/a0/Bill_Gates_2018.jpg",
                biografia = "Empresario y ex alcalde provincial. Impulsor de reformas económicas.",
                fechaNacimiento = "05/09/1970",
                profesion = "Administrador de Empresas",
                correo = "clopez@alianzapopular.pe",
                telefono = "+51 966 555 444"
            ),
            CandidatoEntity(
                id = 5,
                nombre = "Rosa",
                apellidos = "Díaz Morales",
                cargo = "Congreso",
                partido = "Partido Democrático",
                region = "Piura",
                fotoUrl = "https://upload.wikimedia.org/wikipedia/commons/2/2e/Prime_Minister_of_New_Zealand_Jacinda_Ardern_in_2018.jpg",
                biografia = "Médica cirujana, especialista en salud pública. Ex directora regional de salud.",
                fechaNacimiento = "28/02/1978",
                profesion = "Médica Cirujana",
                correo = "rdiaz@partidodemo.pe",
                telefono = "+51 955 444 333"
            )
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
            )
        )
    }
}