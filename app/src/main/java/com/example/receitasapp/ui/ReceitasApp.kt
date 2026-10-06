package com.example.receitasapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.receitasapp.navigation.AppRoute
import com.example.receitasapp.viewmodel.ReceitasViewModel
import com.example.receitasapp.ui.screens.DetalheReceitaScreen
import com.example.receitasapp.ui.screens.FavoritosScreen
import com.example.receitasapp.ui.screens.HomeScreen
import com.example.receitasapp.ui.screens.LoginScreen
import com.example.receitasapp.ui.screens.PerfilScreen
import com.example.receitasapp.ui.screens.ReceitasScreen
import com.example.receitasapp.ui.screens.SplashScreen

@Composable
fun ReceitasApp(viewModel: ReceitasViewModel) {
    val navController = rememberNavController()

    Surface(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = AppRoute.Splash
        ) {
            composable<AppRoute.Splash> {
                SplashScreen(
                    onFinished = {
                        // A decisão de destino fica aqui, no componente que chama a Splash.
                        val usuarioEstaLogado = false

                        navController.navigate(
                            if (usuarioEstaLogado) AppRoute.Home else AppRoute.Login
                        ) {
                            popUpTo<AppRoute.Splash> { inclusive = true }
                        }
                    }
                )
            }

            composable<AppRoute.Login> {
                LoginScreen(
                    onLogin = {
                        navController.navigate(AppRoute.Home) {
                            popUpTo<AppRoute.Login> { inclusive = true }
                        }
                    }
                )
            }

            composable<AppRoute.Home> {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = backStackEntry?.destination

                MainScaffold(
                    currentDestination = currentDestination,
                    onTabSelected = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    content = {
                        HomeScreen()
                    }
                )
            }

            composable<AppRoute.Receitas> {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = backStackEntry?.destination

                MainScaffold(
                    currentDestination = currentDestination,
                    onTabSelected = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    content = {
                        ReceitasScreen(
                            viewModel = viewModel,
                            onReceitaClick = { id ->
                                navController.navigate(AppRoute.ReceitaDetalhe(id))
                            }
                        )
                    }
                )
            }

            composable<AppRoute.Favoritos> {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = backStackEntry?.destination

                MainScaffold(
                    currentDestination = currentDestination,
                    onTabSelected = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    content = {
                        FavoritosScreen(viewModel = viewModel)
                    }
                )
            }

            composable<AppRoute.Perfil> {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = backStackEntry?.destination

                MainScaffold(
                    currentDestination = currentDestination,
                    onTabSelected = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    content = {
                        PerfilScreen()
                    }
                )
            }

            composable<AppRoute.ReceitaDetalhe> { backStackEntry ->
                val route = backStackEntry.toRoute<AppRoute.ReceitaDetalhe>()

                DetalheReceitaScreen(
                    receita = viewModel.buscarReceita(route.receitaId),
                    onBack = { navController.popBackStack() },
                    isFavorite = viewModel.favoritos.collectAsState().value.contains(route.receitaId),
                    onFavoriteClick = { viewModel.alternarFavorito(route.receitaId) }
                )
            }
        }
    }
}
