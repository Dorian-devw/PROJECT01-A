package com.proyecto.project01_a.data.repository

import com.proyecto.project01_a.data.model.*
import com.proyecto.project01_a.data.repository.DecidePeruConstants // <-- ¡IMPORTACIÓN CLAVE!
object DecidePeruRepository {

    fun getCandidatosPresidenciales(): List<Candidato> {
        // Lista estática y completa de los 25 departamentos/unidades territoriales de Perú

        return listOf(
            Candidato(
                id = "1",
                nombre = "Rafael López Aliaga",
                partido = "Renovación Popular",
                cargoPostula = "Presidente de la República",
                fotoUrl = "https://pbs.twimg.com/profile_images/1372582295987757058/P2yzmjJP_400x400.jpg",
                edad = 64,
                profesion = "Político, Empresario e Ingeniero Industrial",
                biografia = "Rafael Bernardo López-Aliaga Cazorla (Lima, 11 de febrero de 1961) es un empresario y político peruano. Es miembro del partido Renovación Popular. Fue alcalde metropolitano de Lima desde el 1 de enero de 2023 hasta su renuncia el 13 de octubre de 2025. Fue fundador y accionista de Peruval Corp SA además de ser accionista de Ferrocarril Transandino S. A. Es presidente del directorio de Peru Holding de Turismo (PTHSAA) desde 1991.",
                region = "Lima",
                propuestas = listOf(
                    Propuesta("Seguridad", "Traslado de Delincuentes a Cecot", "Los delincuentes de alta peligrosidad deben ser enviados a las cárceles Cecot de El Salvador.", "Alta"),
                    Propuesta("Justicia", "Reforma Judicial y Fiscal", "Reforma total de Poder Judicial y Fiscalía.", "Alta"),
                    Propuesta("Seguridad", "Control Militar del Orden Interno", "El orden interno debe estar bajo el control del Ejército del Perú.", "Alta"),
                    Propuesta("Seguridad", "Delito de Terrorismo Urbano", "Aprobación urgente del delito de Terrorismo urbano, con delegación para legislar.", "Alta"),
                    Propuesta("Seguridad", "Potenciar Inteligencia Policial", "Equipamiento para potenciar la inteligencia policial y militar (cámaras, drones, interceptación de información y central de recompensas efectivo).", "Media"),
                    Propuesta("Seguridad", "Grilletes Electrónicos", "Implementación de grilletes electrónicos para extranjeros no registrados y delitos menores, con el fin de saber las actividades que realizan.", "Media"),
                    Propuesta("Tecnología", "Sanción a Empresas de Telefonía", "Sanción a gerentes o directores de empresas de telefonía de celulares que no den de baja equipos robados y reportados.", "Media"),
                    Propuesta("Defensa", "Servicio Militar Voluntario con Incentivos", "Servicio militar voluntario con incentivos como beca 18, carrera militar y trabajo con la ingeniería del Ejército.", "Media"),
                    Propuesta("Administración", "Liberación de Efectivos Policiales", "Liberar efectivos policiales de labores administrativas o de vigilancia de fronteras o activos críticos.", "Baja")
                ),

                denuncias = listOf(
                    Denuncia(
                        tipo = "Lavado de activos",
                        descripcion = "Investigación por presunto lavado de activos relacionados con corrupción de funcionarios, a través de empresas del grupo ACRES, por aproximadamente S/ 1 millón.",
                        año = 2022,
                        estado = "En proceso",
                        fuenteUrl = "https://www.pj.gob.pe/wps/wcm/connect/62f8a3004137128aaf6cbf1666a80600/9-9+CASO+LOPEZ+ALIAGA.pdf?MOD=AJPERES&CACHEID=62f8a3004137128aaf6cbf1666a80600"
                    )
                ),

                historial = listOf(
                    CargoAnterior(
                        cargo = "Alcalde de Lima Metropolitana",
                        institucion = "Municipalidad Metropolitana de Lima",
                        periodo = "2023-2025",
                        descripcion = "Electo alcalde de Lima en 2022 por Renovación Popular. Su gestión se centró en convenios con el Ejército para obras públicas y en medidas de seguridad. En 2025 anunció su intención de postular nuevamente a la presidencia."
                    ),
                    CargoAnterior(
                        cargo = "Fundador y Presidente de Renovación Popular",
                        institucion = "Partido Renovación Popular",
                        periodo = "2020-presente",
                        descripcion = "Refundó Solidaridad Nacional bajo el nombre Renovación Popular, con una línea política conservadora y de derecha cristiana. Promovió principios de libre mercado y valores religiosos."
                    ),
                    CargoAnterior(
                        cargo = "Candidato a la Presidencia de la República",
                        institucion = "Renovación Popular",
                        periodo = "Elecciones 2021",
                        descripcion = "Postuló a la presidencia con un discurso conservador y religioso. Obtuvo el 11.75% de los votos válidos, quedando en tercer lugar. Posteriormente apoyó a Keiko Fujimori en segunda vuelta."
                    ),
                    CargoAnterior(
                        cargo = "Presidente del partido Solidaridad Nacional",
                        institucion = "Partido Solidaridad Nacional",
                        periodo = "2019-2020",
                        descripcion = "Asumió la dirección del partido tras la etapa de Luis Castañeda Lossio. En esta etapa buscó reposicionar la agrupación en la política nacional."
                    ),
                    CargoAnterior(
                        cargo = "Candidato al Congreso de la República",
                        institucion = "Alianza Solidaridad Nacional",
                        periodo = "2011",
                        descripcion = "Postuló sin éxito al Congreso, obteniendo 11,877 votos. No logró una curul."
                    ),
                    CargoAnterior(
                        cargo = "Regidor Metropolitano de Lima",
                        institucion = "Municipalidad Metropolitana de Lima",
                        periodo = "2007-2010",
                        descripcion = "Ingresó a la política como regidor de Lima por Unidad Nacional (Solidaridad Nacional fue parte de esta alianza). Respaldó la concesión de la Línea Amarilla a la empresa OAS, luego investigada por corrupción."
                    )
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
                nombre = "Keiko Fujimori Higuchi",
                partido = "Fuerza Popular",
                cargoPostula = "Presidente de la República",
                fotoUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSircVrljTiJB9rWml00GXmMeBk6-jNbXjIJg&s",
                edad = 50,
                profesion = "Administradora",
                biografia = "Administradora y política peruana. Es líder del partido Fuerza Popular y ha sido tres veces candidata presidencial llegando a la segunda vuelta en todas las ocasiones. Es la hija mayor del expresidente Alberto Fujimori, y fue Primera Dama del Perú de 1994 a 2000.",
                region = "Lima",
                propuestas = listOf(
                    Propuesta(
                        categoria = "Seguridad Ciudadana",
                        titulo = "Fortalecimiento de Comisarías y Distrito Seguro",
                        descripcion = "Mejorar comisarías con personal calificado, patrullaje inteligente, mapas del delito, equipamiento adecuado y trabajo coordinado con serenazgo. Se iniciará con programas piloto en distritos priorizados.",
                        prioridad = "Alta"
                    ),
                    Propuesta(
                        categoria = "Sistema Penitenciario",
                        titulo = "Construcción de Nuevos Penales y Reorganización del INPE",
                        descripcion = "Reducir el hacinamiento carcelario con nuevos penales diferenciados por perfil del reo. Implementar libertad vigilada y grilletes electrónicos para delitos menores como medida de despenalización.",
                        prioridad = "Alta"
                    ),
                    Propuesta(
                        categoria = "Justicia y Lucha contra la Corrupción",
                        titulo = "Modernización y Digitalización del Sistema de Justicia",
                        descripcion = "Implementar una plataforma digital integral para expedientes, audiencias y acceso en tiempo real a los procesos. Fortalecer la capacitación de jueces, fiscales y personal judicial.",
                        prioridad = "Alta"
                    ),
                    Propuesta(
                        categoria = "Transparencia y Control Público",
                        titulo = "Fortalecimiento de la Contraloría y Declaraciones Juradas Únicas",
                        descripcion = "Restituir el rol sancionador de la Contraloría General y crear un sistema único de declaraciones juradas de bienes, rentas e intereses para detectar conflictos de interés y sancionar la corrupción.",
                        prioridad = "Alta"
                    )
                ),

                denuncias = listOf(
                    Denuncia(
                        tipo = "Caso Cócteles (Lavado de activos)",
                        descripcion = "Acusada de liderar una organización criminal y lavado de activos por aportes irregulares a sus campañas de 2011 y 2016. El juicio fue anulado por el Tribunal Constitucional en octubre de 2025.",
                        año = 2024,
                        estado = "Archivado",
                        fuenteUrl = "https://es.wikipedia.org/wiki/Juicio_a_Keiko_Fujimori"
                    )
                ),

                historial = listOf(
                    CargoAnterior(
                        cargo = "Candidata Presidencial (3 veces)",
                        institucion = "Fuerza Popular",
                        periodo = "2011, 2016, 2021",
                        descripcion = "Postuló a la presidencia en tres elecciones consecutivas, llegando a la segunda vuelta en todas las ocasiones."
                    ),
                    CargoAnterior(
                        cargo = "Congresista de la República",
                        institucion = "Congreso de la República",
                        periodo = "2006-2011",
                        descripcion = "Elegida congresista por Lima en las elecciones de 2006, fue la legisladora con mayor votación a nivel nacional."
                    ),
                    CargoAnterior(
                        cargo = "Primera Dama del Perú",
                        institucion = "Presidencia de la República",
                        periodo = "1994-2000",
                        descripcion = "Asumió el rol de Primera Dama tras la destitución de su madre, Susana Higuchi."
                    )
                ),

                financiamiento = Financiamiento(
                    montoDeclared = "Aproximadamente 5 millones de dólares (No declarado)",
                    fuentesPrincipales = listOf(
                        "Odebrecht (1.2 millones USD)",
                        "Credicorp (3.65 millones USD, Dionisio Romero Paoletti)",
                        "Grupo Gloria (200 mil USD, Vito Rodríguez Rodríguez)"
                    ),
                    transparencia = "Baja"
                ),

                redesSociales = RedesSociales(
                    facebook = "https://www.facebook.com/KeikoFujimoriH/",
                    twitter = "https://twitter.com/KeikoFujimori",
                    instagram = "https://www.instagram.com/keikofujimori/",
                    webOficial = "https://fuerzapopular.com.pe"
                )
            ),
            Candidato(
                id = "3",
                nombre = "Mario Vizcarra Cornejo",
                partido = "Perú Primero",
                cargoPostula = "Presidente de la República",
                fotoUrl = "https://f.rpp-noticias.io/2025/08/25/500450_1784627.jpg?imgdimension=n_medium",
                edad = 65,
                profesion = "Empresario / Ingeniero Industrial",
                biografia = "Empresario peruano, hermano del expresidente Martín Vizcarra. Es integrante del partido Perú Primero y ha sido un colaborador clave en las campañas políticas de su hermano. Su candidatura a la presidencia en 2026 es especulativa. Actualmente enfrenta una investigación fiscal por presuntos delitos de colusión y peculado.",
                region = "Lima",
                propuestas = listOf(
                    Propuesta("Generales", "Pendiente de Publicación", "Aún no se han oficializado las propuestas detalladas de la candidatura.", "Baja")
                ),
                denuncias = listOf(
                    Denuncia(
                        tipo = "Colusión y Peculado",
                        descripcion = "Investigación fiscal por presuntos delitos vinculados a contratos estatales de la empresa familiar C y M Vizcarra S.A.C.",
                        año = 2024,
                        estado = "En proceso",
                        fuenteUrl = "https://investigacion.fuente.com"
                    )
                ),

                historial = listOf(),
                financiamiento = Financiamiento(
                    montoDeclared = "S/ 0 (Pendiente de declarar)",
                    fuentesPrincipales = listOf("No declaradas"),
                    transparencia = "Baja"
                ),

                redesSociales = RedesSociales(
                    facebook = "https://facebook.com/mariovizcarra",
                    twitter = "https://twitter.com/mariovizcarra",
                    instagram = "https://instagram.com/mariovizcarra",
                    webOficial = "https://peruprimero.com"
                )
            ),
            Candidato(
                id = "4",
                nombre = "Carlos Alvarez Loayza",
                partido = "País para Todos",
                cargoPostula = "Presidente de la República",
                fotoUrl = "https://storage.googleapis.com/repositorio-willax-prd/web-willax-assets/migrated/2018/07/alvarez.png",
                edad = 61,
                profesion = "Comediante - Guionista",

                biografia = "Carlos Álvarez (Lima, 7 de enero de 1964) es un comediante y presentador peruano conocido por sus imitaciones políticas. En 2024 se unió al partido País para Todos y en 2025 anunció su interés en postular a la presidencia en las elecciones de 2026.",
                region = "Lima",
                propuestas = listOf(
                    Propuesta(
                        categoria = "Seguridad Ciudadana",
                        titulo = "Implementar la pena de muerte para sicarios y criminales violentos",
                        descripcion = "Propone aplicar la pena de muerte como medida extrema contra la delincuencia y el sicariato, argumentando que el Estado debe proteger a los ciudadanos de criminales irrecuperables.",
                        prioridad = "Alta"
                    ),
                    Propuesta(
                        categoria = "Relaciones Internacionales",
                        titulo = "Retirar al Perú del Pacto de San José",
                        descripcion = "Busca que el Perú se retire de la Convención Americana sobre Derechos Humanos para poder aplicar sanciones más severas como la pena de muerte sin restricciones internacionales.",
                        prioridad = "Alta"
                    ),
                    Propuesta(
                        categoria = "Justicia y Anticorrupción",
                        titulo = "Cadena perpetua para delitos graves de corrupción",
                        descripcion = "Plantea cadena perpetua para funcionarios o autoridades cuya corrupción haya causado muertes, como en la pandemia del COVID-19.",
                        prioridad = "Alta"
                    ),
                    Propuesta(
                        categoria = "Salud Pública",
                        titulo = "Comisión de la Verdad sobre la pandemia del COVID-19",
                        descripcion = "Propone crear una comisión que investigue irregularidades y responsabilidades en la gestión estatal de la pandemia.",
                        prioridad = "Media"
                    ),
                    Propuesta(
                        categoria = "Reforma Judicial",
                        titulo = "Reforma profunda del sistema judicial",
                        descripcion = "Pretende una reforma estructural del Poder Judicial con participación de constitucionalistas, académicos y exmagistrados del Tribunal Constitucional.",
                        prioridad = "Alta"
                    ),
                    Propuesta(
                        categoria = "Gobernabilidad",
                        titulo = "Revisión del artículo 117 de la Constitución",
                        descripcion = "Busca modificar el artículo que impide investigar a presidentes en funciones por corrupción, promoviendo una mayor rendición de cuentas.",
                        prioridad = "Media"
                    ),
                    Propuesta(
                        categoria = "Política General",
                        titulo = "Gobierno pragmático sin ideología",
                        descripcion = "Afirma no ser de izquierda, derecha ni centro, sino pragmático; plantea un gobierno basado en sentido común y resultados concretos.",
                        prioridad = "Media"
                    ),
                    Propuesta(
                        categoria = "Política Social",
                        titulo = "Mejora de servicios básicos y reducción de la anemia",
                        descripcion = "Promueve hospitales con medicinas, educación de calidad y políticas efectivas para reducir la anemia infantil.",
                        prioridad = "Media"
                    ),
                    Propuesta(
                        categoria = "Seguridad Ciudadana",
                        titulo = "Modelo de seguridad inspirado en El Salvador",
                        descripcion = "Propone un sistema de seguridad similar al modelo salvadoreño, con firmeza frente al crimen, pero respetando los derechos humanos.",
                        prioridad = "Alta"
                    )
                ),

                denuncias = listOf(),
                historial = listOf(),
                financiamiento = Financiamiento(
                    montoDeclared = "S/ 0 (Pendiente de declarar)",
                    fuentesPrincipales = listOf("No declaradas"),
                    transparencia = "Baja"
                ),
                redesSociales = RedesSociales(
                    facebook = "https://facebook.com/carlosalvarez",
                    twitter = "https://twitter.com/carlosalvarez",
                    instagram = "https://instagram.com/carlosalvarez",
                    webOficial = "https://paisparatodos"
                )
            ),

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
                porcentaje = "10%",
                partido = "Renovación Popular",
                imagenUrl = "https://pbs.twimg.com/profile_images/1372582295987757058/P2yzmjJP_400x400.jpg"
            ),
            CandidatoDestacado(
                id = "keiko_fujimori",
                nombre = "Keiko Fujimori",
                porcentaje = "7%",
                partido = "Fuerza Popular",
                imagenUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSircVrljTiJB9rWml00GXmMeBk6-jNbXjIJg&s"

            ),
            CandidatoDestacado(
                id = "mario_vizcarra",
                nombre = "Mario Vizcarra",
                porcentaje = "7%",
                partido = "Perú Primero",
                imagenUrl = "https://f.rpp-noticias.io/2025/08/25/500450_1784627.jpg?imgdimension=n_medium"

            ),
            CandidatoDestacado(
                id = "carlos_alvarez",
                nombre = "Carlos Álvarez",
                porcentaje = "4%",
                partido = "País para Todos",
                imagenUrl = "https://storage.googleapis.com/repositorio-willax-prd/web-willax-assets/migrated/2018/07/alvarez.png"
            ),
            CandidatoDestacado(
                id = "phillip_butters",
                nombre = "Phillip Butters",
                porcentaje = "3%",
                partido = "Avanza País",
                imagenUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTurIcqYrhwZh-E8rMm69RyQDY2J-a6Amm7PA&s"
            ),
            CandidatoDestacado(
                id = "cesar_acuña",
                nombre = "César Acuña",
                porcentaje = "2%",
                partido = "Alianza para el Progreso",
                imagenUrl = "https://res.cloudinary.com/dku8g6qh3/image/upload/t_thumb-avatar/v1701462402/XIVCONGRESO/AVATARS/kq5ovzzlwojv2lij3vea.jpg"

            ),
            CandidatoDestacado(
                id = "yonhy_lescano",
                nombre = "Yonhy Lescano",
                porcentaje = "2%",
                partido = "Cooperación Popular",
                imagenUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqgvmq2wnbEC57TIkmmHPmdyb-B8owKBrwTQ&s"
            ),
            CandidatoDestacado(
                id = "rafael_belaunde",
                nombre = "Rafael Belaunde",
                porcentaje = "2%",
                partido = "Libertad Popular",
                imagenUrl = "https://pbs.twimg.com/profile_images/1937341132356091904/TQhYRyWS_400x400.jpg"

            ),
            CandidatoDestacado(
                id = "guillermo_bermejo",
                nombre = "Guillermo Bermejo",
                porcentaje = "2%",
                partido = " Alianza Electoral",
                imagenUrl = "https://cloudfront-us-east-1.images.arcpublishing.com/infobae/GNGFLZW6INFTTLLK445BNQMGSE.jpg"
            ),

        )
    }

    fun getCandidatoById(id: String): Candidato? {
        return getCandidatosPresidenciales().find { it.id == id }
    }

    fun getPartidoById(id: String): Partido? {
        return getPartidos().find { it.id == id }
    }

    fun getCandidatoCongresoById(id: String): CandidatoCongreso? {
        return getCandidatosCongreso().find { it.id == id }
    }
    fun getContenidoEducativoDetail(id: String): ContenidoEducativo? {
        return getContenidoEducativo().find { it.id == id }
    }

    fun getCandidatoDetail(id: String): Candidato? {
        return getCandidatosPresidenciales().find { it.id == id }
    }
    fun getEncuestaFuenteUrl(): String {
        return "https://www.ipsos.com/es-pe/intencion-de-voto-septiembre-2025-ii-encuesta-america-tv-ipsos"
    }
    fun getAllPeruDepartmentsForFilter(): List<String> {
        // Retorna la lista de constantes, añadiendo "Todos" al inicio.
        return listOf("Todos") + DecidePeruConstants.ALL_PERU_DEPARTMENTS.sorted()
    }
    fun getAllUniquePartidosForFilter(): List<String> {
        val uniquePartidos = getCandidatosPresidenciales()
            .map { it.partido }
            .distinct()
            .sorted()
        return listOf("Todos") + uniquePartidos
    }

}

