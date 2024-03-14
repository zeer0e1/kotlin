package br.com.alura.aluragames.modelo
data class InfoJogo (val info: InfoApiShark) {
    override fun toString(): String {
        return  info.toString();
    }
}