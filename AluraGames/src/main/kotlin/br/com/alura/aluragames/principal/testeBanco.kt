package br.com.alura.aluragames.principal

import br.com.alura.aluragames.dados.Banco
import br.com.alura.aluragames.dados.GamersDAO
import br.com.alura.aluragames.dados.JogosDAO
import br.com.alura.aluragames.modelo.Gamer
import br.com.alura.aluragames.modelo.Jogo

fun main(){
    val jogo = Jogo("Lol",
        "https://www.bing.com/images/com%2fth%2fid%2fR"
    ,399.0,"jogo de fada")
    val jogo2 = Jogo("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")
    val manager = Banco.getEntityManager()

    val jogosDAO = JogosDAO(manager)
    val gamersDAO = GamersDAO(manager)

    jogosDAO.adicionarJogo(jogo2)

    val listaJogos: List<Jogo> = jogosDAO.getJogos()
    val listaGamers: List<Gamer> = gamersDAO.getGamers()

    //println(listaJogos)
    println(listaGamers)
    manager.close()
}