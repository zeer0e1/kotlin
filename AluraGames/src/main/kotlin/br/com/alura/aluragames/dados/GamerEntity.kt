package br.com.alura.aluragames.dados

import javax.persistence.*

@Entity
@Table(name = "gamers")
class GamerEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val nome: String = "Nome do gamer",
    val email:String = "email do gamer",
    val dataNascimento:String = "01/01/1999",
    val usuario: String = "usuario do gamer",
    val idInterno:String = "id usuario") {
}