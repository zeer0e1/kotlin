package br.com.alura.aluragames.modelo

import java.util.Scanner
import kotlin.random.Random

data class Gamer(val nome: String, var email: String ):Recomendavel {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    var idInterno: String? = null
        private set
    var plano: Plano = PlanoAvulso("BRONZE")
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()
    private val listaNotas = mutableListOf<Int>()
    val  jogosRecomendados = mutableListOf<Jogo>()


    override val media: Double
        get() = listaNotas.average()

    fun recomendarJogo(jogo: Jogo, nota: Int){
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)
    }

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10){
            println("Nota inválida")
        }else{
        listaNotas.add(nota)

        }
    }

    constructor(nome: String, email: String, dataNascimento: String, usuario: String) :
            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

//    init {
//        if (nome.isBlank()) {
//            throw IllegalArgumentException("Nome inválido")
//        }
//        this.email = validarEmail()
//    }

    override fun toString(): String {
        return "Jogador(nome='$nome', " +
                "email='$email', " +
                "dataNascimento=$dataNascimento, " +
                "usuario=$usuario, " +
                "idInterno=$idInterno) \n" +
                "Reputação=$media"
    }


    private fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)
        return aluguel
    }
    
    fun jogosDoMes(mes:Int): List<Jogo>{
        return  jogosAlugados
            .filter { aluguel -> aluguel.periodo.dataFinal.monthValue == mes }
            .map { aluguel -> aluguel.jogo  }
    }
    


    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
                return Gamer(nome, email)
            }
        }
    }


}
