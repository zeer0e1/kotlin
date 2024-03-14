package br.com.alura.aluragames.principal

import tranformaIdade
import br.com.alura.aluragames.modelo.Game
import br.com.alura.aluragames.modelo.Jogador
import br.com.alura.aluragames.services.ConsumoApi
import java.util.*


fun main() {
    var meuJogo: Game? = null
    val leitura = Scanner(System.`in`)

    val jogador = Jogador.criarGamer(leitura)
    println("Cadastro concluido com sucesso. Dados do gamer")
    println(jogador)
    println("Idade do gamer: "+ jogador.dataNascimento?.tranformaIdade())

    do {
        println("Digite um código de jogo para buscar: ")
        val codigo = leitura.nextLine()

        val buscaApi = ConsumoApi()

        val meuInfoJogo = buscaApi.buscaJogo(codigo)

        val resultado = runCatching {
            meuJogo = Game(
                meuInfoJogo.info.title,
                meuInfoJogo.info.thumb
            )
        }

        resultado.onFailure {
            println("Jogo inexistente tente outro id")
        }

        resultado.onSuccess {
            print("Deseja adicionar uma descrição no jogo ?(s/n): ")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Digite a descrição do game: ")
                val descricaoGame = leitura.nextLine()
                meuJogo?.descricao = descricaoGame
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
            jogador.jogosBuscados.add(meuJogo)
        }
        println("Deseja buscar um novo jogo ? S/N")
        val resposta = leitura.nextLine()
    } while (resposta.equals("s", true))
    println("Jogos buscados: ")
    println(jogador.jogosBuscados)

    println("\nJogos ordenados por título: ")
    jogador.jogosBuscados.sortBy {
        it?.titulo
    }

    jogador.jogosBuscados.forEach{
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = jogador.jogosBuscados.filter {
        it?.titulo?.contains("batman",true) ?: false
    }
    println("\nJogos filtrados")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("s",true)){
        println(jogador.jogosBuscados)
        println("\nDigite a posição do jogo: ")
        val posicao = leitura.nextInt()
        jogador.jogosBuscados.removeAt(posicao)

    }

    println("Lista atualizada")
    println(jogador.jogosBuscados)

    println("Busca finalizada com sucesso.")

}