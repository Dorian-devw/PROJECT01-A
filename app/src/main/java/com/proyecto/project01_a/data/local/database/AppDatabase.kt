package com.proyecto.project01_a.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proyecto.project01_a.data.local.dao.*
import com.proyecto.project01_a.data.local.entities.*

@Database(
    entities = [
        Partido::class,
        Candidato::class,
        Propuesta::class,
        Denuncia::class,
        CargoAnterior::class,
        Financiamiento::class,
        RedesSociales::class,
        CandidatoCongreso::class,
        CandidatoDestacado::class,
        Noticia::class,
        ContenidoEducativo::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    // DAO
    abstract fun partidoDao(): PartidoDao
    abstract fun candidatoDao(): CandidatoDao
    abstract fun propuestaDao(): PropuestaDao
    abstract fun denunciaDao(): DenunciaDao
    abstract fun cargoAnteriorDao(): CargoAnteriorDao
    abstract fun financiamientoDao(): FinanciamientoDao
    abstract fun redesSocialesDao(): RedesSocialesDao
    abstract fun candidatoCongresoDao(): CandidatoCongresoDao
    abstract fun candidatoDestacadoDao(): CandidatoDestacadoDao
    abstract fun noticiaDao(): NoticiaDao
    abstract fun contenidoEducativoDao(): ContenidoEducativoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "elecciones_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
