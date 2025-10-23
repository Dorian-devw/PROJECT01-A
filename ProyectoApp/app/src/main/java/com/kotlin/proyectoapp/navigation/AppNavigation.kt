package com.kotlin.proyectoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kotlin.proyectoapp.data.repository.CandidatoRepository
import com.kotlin.proyectoapp.ui.screens.comparar.CompararScreen
import com.kotlin.proyectoapp.ui.screens.comparar.CompararViewModel
import com.kotlin.proyectoapp.ui.screens.comparar.CompararViewModelFactory
import com.kotlin.proyectoapp.ui.screens.detalle.DetalleScreen
import com.kotlin.proyectoapp.ui.screens.detalle.DetalleViewModel
import com.kotlin.proyectoapp.ui.screens.detalle.DetalleViewModelFactory
import com.kotlin.proyectoapp.ui.screens.home.HomeScreen
import com.kotlin.proyectoapp.ui.screens.home.HomeViewModel
import com.kotlin.proyectoapp.ui.screens.home.HomeViewModelFactory

@Composable
fun AppNavigation(
    repository: CandidatoRepository,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            val viewModel: HomeViewModel = viewModel(
                factory = HomeViewModelFactory(repository)
            )
            HomeScreen(
                viewModel = viewModel,
                onCandidatoClick = { candidatoId ->
                    navController.navigate(Screen.Detalle.createRoute(candidatoId))
                },
                onCompararClick = {
                    navController.navigate(Screen.Comparar.route)
                }
            )
        }

        composable(
            route = Screen.Detalle.route,
            arguments = listOf(
                navArgument("candidatoId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val candidatoId = backStackEntry.arguments?.getInt("candidatoId") ?: 0
            val viewModel: DetalleViewModel = viewModel(
                factory = DetalleViewModelFactory(repository, candidatoId)
            )
            DetalleScreen(
                viewModel = viewModel,
                onBackClick = { navController.navigateUp() }
            )
        }

        composable(Screen.Comparar.route) {
            val viewModel: CompararViewModel = viewModel(
                factory = CompararViewModelFactory(repository)
            )
            CompararScreen(
                viewModel = viewModel,
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}