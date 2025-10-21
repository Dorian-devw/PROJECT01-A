package com.kotlin.proyectoapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detalle : Screen("detalle/{candidatoId}") {
        fun createRoute(candidatoId: Int) = "detalle/$candidatoId"
    }
    object Comparar : Screen("comparar")
}