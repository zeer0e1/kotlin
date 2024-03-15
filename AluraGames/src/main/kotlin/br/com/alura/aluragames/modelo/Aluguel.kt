package br.com.alura.aluragames.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
) {
    val valorAluguel = gamer.plano.obterValor(this)

    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo} por ${gamer.nome} pelo valor $valorAluguel"
    }
}

