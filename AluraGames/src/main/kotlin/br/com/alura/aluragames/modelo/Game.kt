package br.com.alura.aluragames.modelo

data class Game (val titulo: String,
                 val capa: String) {
    var descricao:String? = null
    override fun toString(): String {
        return "Titulo: $titulo\n" +
                "Capa: $capa\n" +
                "descricao: $descricao\n"
    }
}