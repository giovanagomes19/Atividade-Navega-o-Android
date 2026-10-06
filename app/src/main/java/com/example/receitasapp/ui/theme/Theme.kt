package com.example.receitasapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val ReceitasLightColors = lightColorScheme(
    primary = Terracota,
    onPrimary = Branco,
    primaryContainer = Pessego,
    onPrimaryContainer = TerracotaEscuro,
    secondary = VerdeSage,
    onSecondary = Branco,
    secondaryContainer = VerdeClaro,
    onSecondaryContainer = Marrom,
    background = Creme,
    onBackground = Marrom,
    surface = Branco,
    onSurface = Marrom,
    surfaceVariant = Bege,
    onSurfaceVariant = Marrom
)

@Composable
fun ReceitasAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ReceitasLightColors,
        content = content
    )
}
