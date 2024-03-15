package br.com.alura.aluragames.modelo

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)
}