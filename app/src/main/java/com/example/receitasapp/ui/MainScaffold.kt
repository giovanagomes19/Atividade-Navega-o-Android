package com.example.receitasapp.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.example.receitasapp.navigation.AppRoute
import kotlin.reflect.KClass

private data class BottomItem(
    val label: String,
    val icon: ImageVector,
    val route: AppRoute,
    val routeClass: KClass<out AppRoute>
)

@Composable
fun MainScaffold(
    currentDestination: NavDestination?,
    onTabSelected: (AppRoute) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val items = listOf(
        BottomItem("Início", Icons.Default.Home, AppRoute.Home, AppRoute.Home::class),
        BottomItem("Receitas", Icons.Default.RestaurantMenu, AppRoute.Receitas, AppRoute.Receitas::class),
        BottomItem("Favoritos", Icons.Default.Favorite, AppRoute.Favoritos, AppRoute.Favoritos::class)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    val selected = currentDestination?.hasRoute(item.routeClass) == true

                    NavigationBarItem(
                        selected = selected,
                        onClick = { onTabSelected(item.route) },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label
                            )
                        },
                        label = { Text(item.label) }
                    )
                }
            }
        },
        content = content
    )
}
