package br.com.alura.aluragames.utlitario

import br.com.alura.aluragames.modelo.InfoJogoJson
import br.com.alura.aluragames.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo{
    return Jogo(this.titulo,
        this.capa,
        this.preco,
        this.descricao)
}