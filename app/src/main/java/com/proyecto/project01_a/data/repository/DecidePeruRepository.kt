package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.model.*
import com.proyecto.project01_a.R
object DecidePeruRepository {

    fun getCandidatosPresidenciales(): List<Candidato> {
        return listOf(
            Candidato(
                id = "1",
                nombre = "Rafael López Aliaga",
                partido = "Renovación Popular",
                cargoPostula = "Presidente de la República",
                fotoUrl = "https://via.placeholder.com/200",
                edad = 60,
                profesion = "Empresario",
                biografia = "Empresario peruano, ex alcalde de Lima y fundador de Renovación Popular. Ha sido vocal en temas de libre mercado y conservadurismo social.",
                propuestas = listOf(
                    Propuesta("Economía", "Reducción de impuestos", "Propone reducir la carga tributaria para empresas y personas naturales.", "Alta"),
                    Propuesta("Seguridad", "Mano dura contra el crimen", "Implementación de políticas de seguridad más estrictas.", "Alta"),
                    Propuesta("Educación", "Reforma educativa", "Mejorar la calidad educativa con énfasis en valores.", "Media")
                ),
                denuncias = listOf(
                    Denuncia("Corrupción", "Investigación por presunto conflicto de intereses", 2023, "En proceso", "https://fuente.com")
                ),
                historial = listOf(
                    CargoAnterior("Alcalde de Lima", "Municipalidad Metropolitana de Lima", "2019-2022", "Gestión enfocada en obras públicas y seguridad ciudadana.")
                ),
                financiamiento = Financiamiento(
                    montoDeclared = "S/ 15,000,000",
                    fuentesPrincipales = listOf("Aportes propios", "Donaciones empresariales"),
                    transparencia = "Media"
                ),
                redesSociales = RedesSociales(
                    facebook = "https://facebook.com/rafaellopezaliaga",
                    twitter = "https://twitter.com/rlopezaliaga",
                    instagram = "https://instagram.com/rafaellopezaliaga",
                    webOficial = "https://renovacionpopular.pe"
                )
            ),
            Candidato(
                id = "2",
                nombre = "Verónika Mendoza",
                partido = "Nuevo Perú",
                cargoPostula = "Presidente de la República",
                fotoUrl = "https://via.placeholder.com/200",
                edad = 43,
                profesion = "Psicóloga y Política",
                biografia = "Psicóloga cusqueña, líder de la izquierda peruana y fundadora del movimiento Nuevo Perú. Ha participado en múltiples elecciones presidenciales.",
                propuestas = listOf(
                    Propuesta("Social", "Reforma de salud universal", "Implementar un sistema de salud gratuito y de calidad para todos.", "Alta"),
                    Propuesta("Ambiente", "Protección de la Amazonía", "Frenar la deforestación y minería ilegal.", "Alta"),
                    Propuesta("Economía", "Justicia tributaria", "Los que más tienen deben pagar más impuestos.", "Media")
                ),
                denuncias = listOf(),
                historial = listOf(
                    CargoAnterior("Congresista", "Congreso de la República", "2011-2016", "Participación activa en comisiones de derechos humanos y medio ambiente.")
                ),
                financiamiento = Financiamiento(
                    montoDeclared = "S/ 8,500,000",
                    fuentesPrincipales = listOf("Aportes de militantes", "Crowdfunding"),
                    transparencia = "Alta"
                ),
                redesSociales = RedesSociales(
                    facebook = "https://facebook.com/veronikmendozaf",
                    twitter = "https://twitter.com/veronikamendoza",
                    instagram = "https://instagram.com/veronikmendozaf",
                    webOficial = "https://nuevoperu.pe"
                )
            ),
            Candidato(
                id = "3",
                nombre = "Daniel Urresti",
                partido = "Podemos Perú",
                cargoPostula = "Presidente de la República",
                fotoUrl = "https://via.placeholder.com/200",
                edad = 62,
                profesion = "Militar retirado y Político",
                biografia = "General del Ejército del Perú en retiro, ex ministro del Interior. Conocido por su postura firme en temas de seguridad.",
                propuestas = listOf(
                    Propuesta("Seguridad", "Guerra frontal contra el crimen", "Despliegue de fuerzas militares en zonas de alta criminalidad.", "Alta"),
                    Propuesta("Justicia", "Reforma del sistema judicial", "Eliminar la corrupción en el Poder Judicial.", "Alta"),
                    Propuesta("Empleo", "Generación de empleo formal", "Incentivar la creación de empleos en zonas rurales.", "Media")
                ),
                denuncias = listOf(
                    Denuncia("Homicidio", "Proceso por caso Hugo Bustíos", 2022, "Absuelto", "https://fuente.com")
                ),
                historial = listOf(
                    CargoAnterior("Ministro del Interior", "Gobierno del Perú", "2014-2015", "Gestión enfocada en combate al terrorismo y narcotráfico."),
                    CargoAnterior("Congresista", "Congreso de la República", "2020-2021", "Labor legislativa en comisiones de defensa.")
                ),
                financiamiento = Financiamiento(
                    montoDeclared = "S/ 10,000,000",
                    fuentesPrincipales = listOf("Aportes personales", "Donaciones privadas"),
                    transparencia = "Media"
                ),
                redesSociales = RedesSociales(
                    facebook = "https://facebook.com/danielurresti",
                    twitter = "https://twitter.com/danielurresti",
                    instagram = "https://instagram.com/danielurresti",
                    webOficial = "https://podemosperu.pe"
                )
            )
        )
    }

    fun getPartidos(): List<Partido> {
        return listOf(
            Partido(
                id = "1",
                nombre = "Renovación Popular",
                nombreCorto = "RP",
                logoUrl = "https://via.placeholder.com/150",
                fundacion = 2019,
                ideologia = "Centro-derecha, Conservadurismo",
                descripcion = "Partido político fundado por Rafael López Aliaga, enfocado en libre mercado y valores conservadores.",
                lider = "Rafael López Aliaga",
                miembrosDestacados = listOf("Rafael López Aliaga", "Alejandro Muñoz", "Norma Yarrow"),
                propuestasGenerales = listOf("Reducción de impuestos", "Seguridad ciudadana", "Educación en valores"),
                webOficial = "https://renovacionpopular.pe"
            ),
            Partido(
                id = "2",
                nombre = "Nuevo Perú",
                nombreCorto = "NP",
                logoUrl = "https://via.placeholder.com/150",
                fundacion = 2016,
                ideologia = "Izquierda democrática",
                descripcion = "Movimiento político progresista liderado por Verónika Mendoza, enfocado en justicia social y medio ambiente.",
                lider = "Verónika Mendoza",
                miembrosDestacados = listOf("Verónika Mendoza", "Marco Arana", "Indira Huilca"),
                propuestasGenerales = listOf("Salud universal", "Protección ambiental", "Justicia tributaria"),
                webOficial = "https://nuevoperu.pe"
            ),
            Partido(
                id = "3",
                nombre = "Podemos Perú",
                nombreCorto = "PP",
                logoUrl = "https://via.placeholder.com/150",
                fundacion = 2018,
                ideologia = "Centro-izquierda",
                descripcion = "Partido político fundado por José León, enfocado en seguridad y empleo.",
                lider = "José León",
                miembrosDestacados = listOf("Daniel Urresti", "José León", "Enrique Wong"),
                propuestasGenerales = listOf("Seguridad nacional", "Reforma judicial", "Empleo formal"),
                webOficial = "https://podemosperu.pe"
            )
        )
    }

    fun getCandidatosCongreso(): List<CandidatoCongreso> {
        return listOf(
            CandidatoCongreso(
                id = "c1",
                nombre = "María Fernández",
                partido = "Renovación Popular",
                region = "Lima",
                fotoUrl = "https://via.placeholder.com/150",
                edad = 45,
                profesion = "Abogada",
                propuestas = listOf("Reforma laboral", "Seguridad jurídica", "Descentralización"),
                historial = "Ex regidora de Lima Metropolitana (2015-2018)"
            ),
            CandidatoCongreso(
                id = "c2",
                nombre = "Carlos Rodríguez",
                partido = "Nuevo Perú",
                region = "Cusco",
                fotoUrl = "https://via.placeholder.com/150",
                edad = 38,
                profesion = "Ingeniero Ambiental",
                propuestas = listOf("Protección de recursos naturales", "Turismo sostenible", "Educación rural"),
                historial = "Activista ambiental (2010-presente)"
            ),
            CandidatoCongreso(
                id = "c3",
                nombre = "Ana Gutiérrez",
                partido = "Podemos Perú",
                region = "Arequipa",
                fotoUrl = "https://via.placeholder.com/150",
                edad = 52,
                profesion = "Economista",
                propuestas = listOf("Desarrollo regional", "Emprendimiento", "Infraestructura"),
                historial = "Gerente Regional de Desarrollo Económico (2016-2020)"
            )
        )
    }

    fun getNoticias(): List<Noticia> {
        return listOf(
            Noticia(
                id = "n1",
                titulo = "JNE aprueba lista final de candidatos presidenciales para 2026",
                descripcion = "El Jurado Nacional de Elecciones confirmó la inscripción de 18 candidatos para las elecciones generales.",
                fuente = "El Comercio",
                fecha = "15 de octubre, 2025",
                imagenUrl = "https://via.placeholder.com/300x150",
                url = "https://elcomercio.pe",
                categoria = "Política"
            ),
            Noticia(
                id = "n2",
                titulo = "Debate presidencial se realizará en marzo de 2026",
                descripcion = "Los candidatos participarán en tres debates organizados por medios de comunicación nacionales.",
                fuente = "RPP Noticias",
                fecha = "10 de octubre, 2025",
                imagenUrl = "https://via.placeholder.com/300x150",
                url = "https://rpp.pe",
                categoria = "Política"
            ),
            Noticia(
                id = "n3",
                titulo = "ONPE inicia preparativos logísticos para elecciones 2026",
                descripcion = "La Oficina Nacional de Procesos Electorales comenzó la distribución de materiales electorales.",
                fuente = "Gestión",
                fecha = "5 de octubre, 2025",
                imagenUrl = "https://via.placeholder.com/300x150",
                url = "https://gestion.pe",
                categoria = "Política"
            )
        )
    }

    fun getContenidoEducativo(): List<ContenidoEducativo> {
        return listOf(
            ContenidoEducativo(
                id = "e1",
                titulo = "¿Qué hace el Presidente de la República?",
                descripcion = "Conoce las funciones y responsabilidades del Poder Ejecutivo.",
                categoria = "Poderes del Estado",
                contenido = """
                    El Presidente de la República es el Jefe del Estado y personifica a la Nación. 
                    
                    Sus principales funciones son:
                    
                    • Dirigir la política general del Gobierno
                    • Representar al Estado dentro y fuera del territorio nacional
                    • Velar por el orden interno y la seguridad exterior
                    • Convocar a elecciones y promulgar leyes
                    • Nombrar y remover al Presidente del Consejo de Ministros
                    • Dirigir la política exterior y las relaciones internacionales
                    • Cumplir y hacer cumplir la Constitución
                    
                    El Presidente es elegido por voto popular directo y su mandato dura cinco años, sin reelección inmediata.
                """.trimIndent(),
                iconoUrl = null
            ),
            ContenidoEducativo(
                id = "e2",
                titulo = "¿Qué hace el Congreso de la República?",
                descripcion = "Entiende el rol del Poder Legislativo en nuestra democracia.",
                categoria = "Poderes del Estado",
                contenido = """
                    El Congreso de la República es el órgano encargado de la función legislativa.
                    
                    Sus principales funciones son:
                    
                    • Aprobar, modificar y derogar leyes
                    • Fiscalizar la gestión del Poder Ejecutivo
                    • Aprobar el Presupuesto de la República
                    • Autorizar empréstitos y tratados internacionales
                    • Interpelar y censurar a ministros
                    • Aprobar la Cuenta General de la República
                    
                    El Congreso está conformado por 130 congresistas elegidos por voto popular directo, quienes representan a todo el país. Su mandato es de cinco años.
                """.trimIndent(),
                iconoUrl = null
            ),
            ContenidoEducativo(
                id = "e3",
                titulo = "¿Cómo funciona el proceso electoral?",
                descripcion = "Descubre cómo se organizan y realizan las elecciones en el Perú.",
                categoria = "Sistema Electoral",
                contenido = """
                    El sistema electoral peruano garantiza elecciones libres, justas y transparentes.
                    
                    Instituciones principales:
                    
                    • JNE (Jurado Nacional de Elecciones): Administra justicia electoral y proclama resultados
                    • ONPE (Oficina Nacional de Procesos Electorales): Organiza y ejecuta los procesos electorales
                    • RENIEC (Registro Nacional de Identificación): Mantiene el padrón electoral
                    
                    Proceso electoral:
                    
                    1. Inscripción de candidatos
                    2. Campaña electoral
                    3. Jornada electoral
                    4. Escrutinio y cómputo de votos
                    5. Proclamación de resultados
                    
                    El voto en el Perú es obligatorio para ciudadanos entre 18 y 70 años.
                """.trimIndent(),
                iconoUrl = null
            ),
            ContenidoEducativo(
                id = "e4",
                titulo = "¿Qué son los partidos políticos?",
                descripcion = "Aprende sobre el rol de los partidos en la democracia.",
                categoria = "Organización Política",
                contenido = """
                    Los partidos políticos son organizaciones que representan diferentes ideologías y propuestas para gobernar el país.
                    
                    Características:
                    
                    • Agrupan a ciudadanos con ideales similares
                    • Presentan candidatos a cargos públicos
                    • Proponen planes de gobierno y políticas públicas
                    • Deben inscribirse ante el JNE
                    
                    En el Perú, los partidos deben cumplir requisitos legales para participar en elecciones, incluyendo un número mínimo de afiliados y presencia en varias regiones del país.
                    
                    Los partidos pueden tener diferentes ideologías: izquierda, centro, derecha, conservadora, progresista, entre otras.
                """.trimIndent(),
                iconoUrl = null
            )
        )
    }

    fun getCandidatosDestacados(): List<CandidatoDestacado> {
        return listOf(
            CandidatoDestacado(
                id = "rafael_lopez",
                nombre = "Rafael Lopez Aliaga",
                partido = "Renovación Popular",
                imagenResId = R.drawable.rafaelopez // Asegúrate de tener esta imagen
            ),
            CandidatoDestacado(
                id = "keiko_fujimori",
                nombre = "Keiko Fujimori",
                partido = "Fuerza Popular",
                imagenResId = R.drawable.keikofujimori // Asegúrate de tener esta imagen
            ),
            CandidatoDestacado(
                id = "mario_vizcarra",
                nombre = "Mario Vizcarra",
                partido = "País para Todos",
                imagenResId = R.drawable.mariovizcarra // Asegúrate de tener esta imagen
            ),
            // ... Puedes agregar más para forzar el scroll
        )
    }


    // --- Implementación de Funciones de Detalle (Por ID) ---

    /** Obtiene el detalle de un Candidato Presidencial por su ID. */
    fun getCandidatoById(id: String): Candidato? {
        return getCandidatosPresidenciales().find { it.id == id }
    }

    /** Obtiene el detalle de un Partido Político por su ID (usado en PartidoDetailScreen). */
    fun getPartidoById(id: String): Partido? {
        return getPartidos().find { it.id == id }
    }

    /** Obtiene el detalle de un Candidato al Congreso por su ID. */
    fun getCandidatoCongresoById(id: String): CandidatoCongreso? {
        return getCandidatosCongreso().find { it.id == id }
    }

    /**
     * Obtiene el detalle de un Contenido Educativo por su ID
     * (Función Requerida para EducacionDetailScreen).
     */
    fun getContenidoEducativoDetail(id: String): ContenidoEducativo? {
        return getContenidoEducativo().find { it.id == id }
    }

    // Puedes añadir una función para obtener el Candidato (general) por ID si es necesario
    fun getCandidatoDetail(id: String): Candidato? {
        return getCandidatosPresidenciales().find { it.id == id }
    }

}

