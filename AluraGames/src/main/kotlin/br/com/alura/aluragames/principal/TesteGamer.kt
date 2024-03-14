import br.com.alura.aluragames.modelo.Jogador

fun main(){
    val gamer1 = Jogador("Lucas","lucazfreitaz@gmail.com")
    println(gamer1)

    val gamer2 = Jogador("Rauana",
        "rauana@gmail.com",
        "14/12/2021",
        "lola")

    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/09/2021"
        it.usuario = "zeer0e1"
    }.also {
        println(gamer1.idInterno)
    }

    println("Depois de atualizar: ")
    println(gamer1)
    gamer1.usuario = "jack"
    println(gamer1)
}