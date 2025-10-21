package com.kotlin.proyectoapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kotlin.proyectoapp.data.local.dao.CandidatoDao
import com.kotlin.proyectoapp.data.local.dao.DenunciaDao
import com.kotlin.proyectoapp.data.local.dao.ProyectoDao
import com.kotlin.proyectoapp.data.local.entities.CandidatoEntity
import com.kotlin.proyectoapp.data.local.entities.DenunciaEntity
import com.kotlin.proyectoapp.data.local.entities.ProyectoEntity

@Database(
    entities = [
        CandidatoEntity::class,
        ProyectoEntity::class,
        DenunciaEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun candidatoDao(): CandidatoDao
    abstract fun proyectoDao(): ProyectoDao
    abstract fun denunciaDao(): DenunciaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "candidatoinfo_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}