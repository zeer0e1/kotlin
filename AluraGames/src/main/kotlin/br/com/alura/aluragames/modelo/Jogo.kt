package br.com.alura.aluragames.modelo

import com.google.gson.annotations.Expose
import javax.persistence.*


data class Jogo(

    @Expose val titulo: String,
    @Expose val capa: String
) : Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    private var id = 0
    private val listaNotas = mutableListOf<Int>()


    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    constructor(titulo: String,
                capa: String,
                preco: Double,
                descricao: String,
                id: Int = 0) :
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }

    override fun toString(): String {
        return "Titulo: $titulo\n" +
                "Capa: $capa\n" +
                "descricao: $descricao\n" +
                "Preco: $preco\n" +
                "Reputacao: $media\n" +
                "Id: $id"
    }
}