package com.example.receitasapp.navigation

import kotlinx.serialization.Serializable

sealed interface AppRoute {

    @Serializable
    data object Splash : AppRoute

    @Serializable
    data object Login : AppRoute

    @Serializable
    data object Home : AppRoute

    @Serializable
    data object Receitas : AppRoute

    @Serializable
    data object Favoritos : AppRoute

    @Serializable
    data object Perfil : AppRoute

    @Serializable
    data class ReceitaDetalhe(val receitaId: Int) : AppRoute
}
