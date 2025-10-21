package com.proyecto.project01_a.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.proyecto.project01_a.ui.screens.*

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object CandidatosList : Screen("candidatos_list")
    object PartidosList : Screen("partidos_list")
    object CandidatoDetail : Screen("candidato/{candidatoId}") {
        fun createRoute(candidatoId: String) = "candidato/$candidatoId"
    }
    object CandidatoCongreso : Screen("congreso")
    object CongresoDetail : Screen("congreso/{congresoId}") {
        fun createRoute(congresoId: String) = "congreso/$congresoId"
    }
    object PartidoDetail : Screen("partido/{partidoId}") {
        fun createRoute(partidoId: String) = "partido/$partidoId"
    }
    object Noticias : Screen("noticias")
    object Educacion : Screen("educacion")
    object EducacionDetail : Screen("educacion/{educacionId}") {
        fun createRoute(educacionId: String) = "educacion/$educacionId"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToCandidatoDetail = { candidatoId ->
                    navController.navigate(Screen.CandidatoDetail.createRoute(candidatoId))
                },
                // 2. NUEVO: Navegación a la Lista General de Candidatos
                onNavigateToCandidatosList = {
                    // Necesitas definir la ruta para la lista general de candidatos.
                    // ASUMIMOS que crearás una nueva ruta: Screen.CandidatosList
                    navController.navigate(Screen.CandidatosList.route)
                },
                // 3. NUEVO: Navegación a Partidos Políticos
                onNavigateToPartidos = {
                    // Necesitas definir la ruta para la lista de partidos.
                    // ASUMIMOS que crearás una nueva ruta: Screen.PartidosList
                    navController.navigate(Screen.PartidosList.route)
                },
                onNavigateToCongreso = {
                    navController.navigate(Screen.CandidatoCongreso.route)
                },
                onNavigateToNoticias = {
                    navController.navigate(Screen.Noticias.route)
                },
                onNavigateToEducacion = {
                    navController.navigate(Screen.Educacion.route)
                }
            )
        }

        composable(
            route = Screen.CandidatoDetail.route,
            arguments = listOf(navArgument("candidatoId") { type = NavType.StringType })
        ) { backStackEntry ->
            val candidatoId = backStackEntry.arguments?.getString("candidatoId") ?: return@composable
            CandidatoDetailScreen(
                candidatoId = candidatoId,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToPartido = { partidoId ->
                    navController.navigate(Screen.PartidoDetail.createRoute(partidoId))
                }
            )
        }

        composable(Screen.CandidatoCongreso.route) {
            CandidatoCongresoScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToDetail = { congresoId ->
                    navController.navigate(Screen.CongresoDetail.createRoute(congresoId))
                }
            )
        }

        composable(
            route = Screen.CongresoDetail.route,
            arguments = listOf(navArgument("congresoId") { type = NavType.StringType })
        ) { backStackEntry ->
            val congresoId = backStackEntry.arguments?.getString("congresoId") ?: return@composable
            CongresoDetailScreen(
                congresoId = congresoId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.PartidoDetail.route,
            arguments = listOf(navArgument("partidoId") { type = NavType.StringType })
        ) { backStackEntry ->
            val partidoId = backStackEntry.arguments?.getString("partidoId") ?: return@composable
            PartidoDetailScreen(
                partidoId = partidoId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Noticias.route) {
            NoticiasScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Educacion.route) {
            EducacionScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToDetail = { educacionId ->
                    navController.navigate(Screen.EducacionDetail.createRoute(educacionId))
                }
            )
        }
        composable(Screen.CandidatosList.route) {
            CandidatosListScreen(
                onNavigateToCandidatoDetail = { candidatoId ->
                    navController.navigate(Screen.CandidatoDetail.createRoute(candidatoId))
                }
                // Si tienes un TopBar, también necesitarás un onNavigateBack
            )
        }

        composable(Screen.PartidosList.route) {
            PartidosListScreen(
                // onNavigateBack = { navController.popBackStack() } // si la creas
            )
        }

        composable(
            route = Screen.EducacionDetail.route,
            arguments = listOf(navArgument("educacionId") { type = NavType.StringType })
        ) { backStackEntry ->
            val educacionId = backStackEntry.arguments?.getString("educacionId") ?: return@composable
            EducacionDetailScreen(
                educacionId = educacionId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}