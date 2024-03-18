package br.com.alura.aluragames.dados

import javax.persistence.*

@Entity
@Table(name = "jogos")
class JogoEntity( val titulo: String = "Titulo do jogo",
                 val capa: String = "Capa do jogo",
                 val preco: Double = 0.0,
                 val descricao: String? = null,
                  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                 val id: Int = 0) {

}