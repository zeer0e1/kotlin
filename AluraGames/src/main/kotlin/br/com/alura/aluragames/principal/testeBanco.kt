package br.com.alura.aluragames.principal

import br.com.alura.aluragames.dados.Banco
import br.com.alura.aluragames.dados.JogosDAO
import br.com.alura.aluragames.modelo.Jogo

fun main(){
    val jogo = Jogo("Lol",
        "https://www.bing.com/images/com%2fth%2fid%2fR"
    ,399.0,"jogo de fada")

    val jogosDAO = JogosDAO()

    jogosDAO.adicionarJogo(jogo)
    val listaJogos: List<Jogo> = jogosDAO.getJogos()

    println(listaJogos)
}