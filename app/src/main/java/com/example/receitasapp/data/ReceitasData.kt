package com.example.receitasapp.data

import com.example.receitasapp.model.Receita

object ReceitasData {
    val receitas = listOf(
        Receita(
            id = 1,
            nome = "Panqueca de Banana",
            categoria = "Café da manhã",
            tempo = "15 min",
            dificuldade = "Fácil",
            descricao = "Uma panqueca simples, rápida e perfeita para começar o dia.",
            ingredientes = listOf("1 banana", "1 ovo", "3 colheres de aveia", "Canela a gosto")
        ),
        Receita(
            id = 2,
            nome = "Macarrão Cremoso",
            categoria = "Almoço",
            tempo = "25 min",
            dificuldade = "Fácil",
            descricao = "Macarrão cremoso com molho suave e muito saboroso.",
            ingredientes = listOf("200 g de macarrão", "1 caixinha de creme de leite", "Molho de tomate", "Queijo ralado")
        ),
        Receita(
            id = 3,
            nome = "Torta de Frango",
            categoria = "Almoço",
            tempo = "50 min",
            dificuldade = "Médio",
            descricao = "Torta caseira de frango com massa fofinha e recheio cremoso.",
            ingredientes = listOf("2 xícaras de farinha", "2 ovos", "Frango desfiado", "Milho", "Requeijão")
        ),
        Receita(
            id = 4,
            nome = "Mousse de Limão",
            categoria = "Sobremesa",
            tempo = "10 min",
            dificuldade = "Fácil",
            descricao = "Sobremesa refrescante e prática para qualquer ocasião.",
            ingredientes = listOf("1 lata de leite condensado", "1 caixa de creme de leite", "Suco de 3 limões")
        )
    )
}
