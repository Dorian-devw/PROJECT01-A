# 🗳️ EligePerú - Transparencia Electoral Ciudadana

## 📋 Descripción del Proyecto

**DecidePeru** es una aplicación móvil Android que permite a los ciudadanos peruanos consultar información pública y verificable sobre candidatos al Congreso y la Presidencia del Perú. La aplicación busca promover la transparencia electoral y facilitar el acceso a datos importantes como denuncias, proyectos legislativos, historial político y enlaces a fuentes oficiales.

### 🎯 Problema que Resuelve

En el Perú, el acceso a información confiable y verificable sobre los candidatos políticos es limitado y fragmentado. Los datos relevantes como antecedentes judiciales, historial político o desempeño legislativo se encuentran dispersos entre múltiples plataformas oficiales (JNE, ONPE, Congreso, Poder Judicial), lo que dificulta su consulta por parte del ciudadano común.

A esto se suma un problema aún más crítico: la distorsión de la información a través de medios de comunicación, redes sociales y opiniones personales, que muchas veces presentan contenido sesgado, incompleto o incluso falso.
Esta sobreexposición a fuentes no verificadas genera confusión, desinformación y desconfianza en los procesos electorales, afectando la capacidad de los votantes para tomar decisiones objetivas y fundamentadas.

DecidePeru surge como una respuesta a esta necesidad, ofreciendo una plataforma centralizada y transparente donde los ciudadanos pueden consultar información pública, verificable y actualizada sobre los candidatos al Congreso y la Presidencia, fomentando así el voto informado y la participación responsable.

### 💡 Valor Social

- ✅ **Transparencia**: Acceso fácil a información pública verificable
- ✅ **Educación Cívica**: Ciudadanos más informados sobre sus candidatos
- ✅ **Comparación Objetiva**: Herramientas para comparar propuestas y antecedentes
- ✅ **Trazabilidad**: Enlaces directos a fuentes oficiales del Estado

## 👥 Equipo de Desarrollo

| Rol | Nombre | Responsabilidades |
|-----|--------|-------------------|
| **Líder Técnico** | Frank Sinca  | Arquitectura, Base de datos Room, Integración |
| **Diseñador UI/UX** | Josue Zapata | Prototipo Figma, Diseño de interfaces en Compose |
| **Documentador/Tester** | Christian Unocc | Documentación técnica, Pruebas, Control de calidad |

## 🎨 Prototipo de Diseño

### Enlace a Figma
🔗 [Ver prototipo en Figma](https://www.figma.com/design/d2wsoxZVmGn2j6joDUovJ3/Proyecto-Kotlin?node-id=15-2&t=2kbL9aXZSsYle7aS-1)

### Pantallas Principales

El prototipo incluye las siguientes pantallas:

1. **Pantalla de Inicio/Búsqueda**
   - Barra de búsqueda inteligente
   - Filtros por cargo (Presidencia/Congreso)
   - Filtros por partido político
   - Filtros por región
   - Lista de candidatos con información básica

2. **Pantalla de Detalle del Candidato**
   - Foto y datos personales
   - Información biográfica
   - Tabs para Proyectos y Denuncias
   - Enlaces a fuentes oficiales verificables

3. **Pantalla de Comparación**
   - Selección múltiple de candidatos (hasta 3)
   - Vista comparativa lado a lado
   - Métricas: proyectos presentados, denuncias, experiencia

### Flujo de Navegación

```
[Inicio] 
   ├── → [Detalle Candidato] 
   │      └── → [Enlace Externo: Fuentes Oficiales]
   └── → [Comparar Candidatos]
          └── → [Volver a Inicio]
```

## 🛠️ Stack Tecnológico

| Categoría | Tecnología | Versión |
|-----------|-----------|---------|
| **Lenguaje** | Kotlin | 1.9.20 |
| **Framework UI** | Jetpack Compose | 2024.02.00 |
| **Arquitectura** | MVVM + Repository Pattern | - |
| **Base de Datos** | Room ORM | 2.6.1 |
| **Navegación** | Navigation Compose | 2.7.6 |
| **Async** | Coroutines + Flow | 1.7.3 |
| **Diseño** | Material Design 3 | - |
| **Control de Versiones** | Git/GitHub | - |

## 🎨 Paleta de Colores

Hemos seleccionado una paleta que transmite **confianza, transparencia y seriedad institucional**:

| Color | Hex | Uso |
|-------|-----|-----|
| **Azul Institucional** | `#1565C0` | Color primario - Botones, AppBar |
| **Verde Confianza** | `#2E7D32` | Color secundario - Estados positivos |
| **Naranja Alerta** | `#F57C00` | Color terciario - Alertas, denuncias |
| **Gris Claro** | `#F5F5F5` | Fondo de la aplicación |
| **Blanco** | `#FFFFFF` | Tarjetas y superficies |
| **Rojo Error** | `#D32F2F` | Errores y estados críticos |

## 📊 Fuentes de Datos

La aplicación se basa en información de las siguientes fuentes oficiales:

| Institución | URL | Información Proporcionada |
|-------------|-----|---------------------------|
| **JNE** | https://www.jne.gob.pe | Hoja de vida, declaraciones juradas |
| **ONPE** | https://www.onpe.gob.pe | Resultados electorales, estadísticas |
| **Congreso** | https://www.congreso.gob.pe | Proyectos de ley, votaciones, asistencias |
| **Poder Judicial** | https://www.pj.gob.pe | Denuncias, sentencias |
| **Infogob** | https://infogob.com.pe | Historial político completo |

> **Nota**: Para esta versión académica (v1.0), utilizaremos datos simulados basados en formatos reales de estas instituciones.

## 📐 Arquitectura de la Información

### Estructura de Datos Principal

```
Candidato
├── Información Personal
│   ├── Nombre completo
│   ├── Fecha de nacimiento
│   ├── Profesión
│   ├── Partido político
│   ├── Región que representa
│   └── Fotografía
├── Proyectos Presentados
│   ├── Título del proyecto
│   ├── Descripción
│   ├── Fecha de presentación
│   ├── Estado (Aprobado/En trámite/Rechazado)
│   └── Enlace a fuente oficial
└── Denuncias
    ├── Tipo (Penal/Civil/Electoral)
    ├── Descripción
    ├── Fecha
    ├── Estado (En proceso/Archivado/Sentenciado)
    └── Enlace a fuente oficial
```

## 🎯 Funcionalidades Principales

### Versión 1.0 (Entregable Final)

- ✅ Búsqueda de candidatos por nombre, partido o región
- ✅ Filtros por cargo (Presidencia/Congreso)
- ✅ Visualización detallada de información de candidatos
- ✅ Lista de proyectos legislativos presentados
- ✅ Lista de denuncias judiciales
- ✅ Enlaces directos a fuentes oficiales
- ✅ Comparación entre 2 o 3 candidatos
- ✅ Interfaz responsive con Material Design 3

### Futuras Mejoras (Post v1.0)

- 📊 Gráficos estadísticos de desempeño
- 🔔 Notificaciones de actualizaciones
- 📤 Compartir información en redes sociales
- 💾 Favoritos y listas personalizadas
- 🌐 Integración con APIs oficiales en tiempo real

## 📅 Cronograma de Desarrollo

| Día | Actividades | Entregables |
|-----|-------------|-------------|
| **Día 1** | Planificación, diseño Figma, setup GitHub | ✅ Prototipo Figma + Repositorio GitHub |
| **Día 2** | Estructura base, Room Database, navegación | Proyecto base con arquitectura definida |
| **Día 3** | Interfaz de usuario (Compose) | UI completa según diseño Figma |
| **Día 4** | Lógica, ViewModels, datos simulados | App funcional con datos |
| **Día 5** | Búsqueda, filtros, comparación | Funcionalidades completas |
| **Día 6** | Testing, documentación, presentación | Release v1.0 + Presentación |

## 🚀 Instalación (Preliminar)

> Esta sección se completará en el **Día 2** cuando el proyecto esté configurado.

```bash
# Clonar el repositorio
git clone https://github.com/[usuario]/EligePeur.git

# Abrir en Android Studio
# File → Open → Seleccionar carpeta del proyecto

# Ejecutar en emulador o dispositivo
# Run → Run 'app'
```

## 📝 Investigación Inicial

### Análisis de Fuentes de Datos

Durante nuestra investigación inicial, identificamos los siguientes puntos clave:

1. **Información más relevante para votantes**:
   - Denuncias penales y civiles
   - Proyectos de ley presentados y su estado
   - Votaciones en sesiones del Congreso
   - Declaraciones juradas de bienes
   - Historial de cargos públicos anteriores

2. **Desafíos técnicos**:
   - Datos dispersos en múltiples fuentes
   - Formatos no estandarizados
   - Actualización manual necesaria
   - No todas las fuentes tienen API pública

3. **Solución propuesta**:
   - Base de datos local con Room
   - Datos simulados realistas para v1.0
   - Enlaces a fuentes oficiales para verificación
   - Estructura escalable para futuras integraciones con APIs

## 📖 Convenciones del Proyecto

### Commits
Usaremos **Conventional Commits** para mantener un historial claro:

```
feat: Nueva funcionalidad
fix: Corrección de errores
docs: Cambios en documentación
style: Formato de código
refactor: Refactorización
test: Pruebas
chore: Tareas de mantenimiento
```

### Ramas
```
main: Código en producción
develop: Rama de desarrollo principal
feature/[nombre]: Nuevas funcionalidades
fix/[nombre]: Correcciones
```

## 📞 Contacto

**Curso**: Aplicaciones Móviles con Android  
**Docente**: Juan León S.  
**Institución**: Tecsup  
**Fecha**: Octubre 2025

---



**Última actualización**: 17/10/2025  
**Versión**: 0.1.0-alpha (Pre-release)

> 💡 **Nota para el equipo**: Mantener este README actualizado conforme avanzamos en el desarrollo. Cada miembro del equipo debe documentar sus avances en sus respectivas secciones.
