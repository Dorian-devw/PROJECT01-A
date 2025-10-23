package com.kotlin.proyectoapp

import android.app.Application
import com.kotlin.proyectoapp.data.local.database.AppDatabase
import com.kotlin.proyectoapp.data.repository.CandidatoRepository
import com.kotlin.proyectoapp.util.DataSeeder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CandidatoInfoApplication : Application() {

    // Base de datos
    val database by lazy { AppDatabase.getDatabase(this) }

    // Repositorio
    val candidatoRepository by lazy {
        CandidatoRepository(
            database.candidatoDao(),
            database.proyectoDao(),
            database.denunciaDao()
        )
    }

    override fun onCreate() {
        super.onCreate()

        // Sembrar datos iniciales
        CoroutineScope(Dispatchers.IO).launch {
            seedDatabase()
        }
    }

    private suspend fun seedDatabase() {
        val candidatoDao = database.candidatoDao()
        val proyectoDao = database.proyectoDao()
        val denunciaDao = database.denunciaDao()

        // Verificar si ya hay datos
        val candidatos = candidatoDao.getAllCandidatos()

        // Si no hay datos, sembrar la base de datos
        candidatos.collect { list ->
            if (list.isEmpty()) {
                candidatoDao.insertAll(DataSeeder.getCandidatosSample())
                proyectoDao.insertAll(DataSeeder.getProyectosSample())
                denunciaDao.insertAll(DataSeeder.getDenunciasSample())
            }
        }
    }
}