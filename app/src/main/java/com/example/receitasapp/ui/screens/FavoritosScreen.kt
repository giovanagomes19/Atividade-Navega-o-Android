package com.example.receitasapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.receitasapp.viewmodel.ReceitasViewModel

@Composable
fun FavoritosScreen(viewModel: ReceitasViewModel) {
    val favoritos by viewModel.favoritos.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favoritos",
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Favoritos",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 12.dp)
        )
        Text(
            text = if (favoritos.isEmpty()) {
                "Você ainda não favoritou nenhuma receita."
            } else {
                "${favoritos.size} receita(s) favorita(s)."
            }
        )
    }
}
