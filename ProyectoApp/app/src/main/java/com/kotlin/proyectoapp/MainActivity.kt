package com.kotlin.proyectoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kotlin.proyectoapp.navigation.AppNavigation
import com.kotlin.proyectoapp.ui.theme.ProyectoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val application = application as ProyectoApplication
        val repository = application.candidatoRepository

        setContent {
            ProyectoAppTheme {
                AppNavigation(repository = repository)
            }
        }
    }
}
