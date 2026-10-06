package com.example.receitasapp.model

data class Receita(
    val id: Int,
    val nome: String,
    val categoria: String,
    val tempo: String,
    val dificuldade: String,
    val descricao: String,
    val ingredientes: List<String>
)
