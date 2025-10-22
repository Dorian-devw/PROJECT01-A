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
        Denuncia::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun partidoDao(): PartidoDao
    abstract fun candidatoDao(): CandidatoDao
    abstract fun propuestaDao(): PropuestaDao
    abstract fun denunciaDao(): DenunciaDao

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
