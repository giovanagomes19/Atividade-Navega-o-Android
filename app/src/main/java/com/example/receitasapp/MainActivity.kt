package com.example.receitasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.receitasapp.ui.ReceitasApp
import com.example.receitasapp.ui.theme.ReceitasAppTheme
import com.example.receitasapp.viewmodel.ReceitasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReceitasAppTheme {
                val receitasViewModel: ReceitasViewModel = viewModel()
                ReceitasApp(viewModel = receitasViewModel)
            }
        }
    }
}
