package br.com.alura.aluragames.utlitario

import br.com.alura.aluragames.modelo.InfoGamerJson
import br.com.alura.aluragames.modelo.Gamer

fun InfoGamerJson.criaGamer():Gamer {
   return Gamer(
       this.nome,
       this.email,
       this.dataNascimento,
       this.usuario
   )
}
