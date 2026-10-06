package com.example.receitasapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.receitasapp.data.ReceitasData
import com.example.receitasapp.model.Receita
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ReceitasViewModel : ViewModel() {

    private val _receitas = MutableStateFlow(ReceitasData.receitas)
    val receitas: StateFlow<List<Receita>> = _receitas.asStateFlow()

    private val _favoritos = MutableStateFlow(setOf<Int>())
    val favoritos: StateFlow<Set<Int>> = _favoritos.asStateFlow()

    fun alternarFavorito(id: Int) {
        _favoritos.value = _favoritos.value.toMutableSet().apply {
            if (!add(id)) remove(id)
        }
    }

    fun buscarReceita(id: Int): Receita? {
        return _receitas.value.firstOrNull { it.id == id }
    }
}
