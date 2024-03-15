package br.com.alura.aluragames.services

import br.com.alura.aluragames.modelo.*
import br.com.alura.aluragames.utlitario.criaGamer
import br.com.alura.aluragames.utlitario.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    private fun consumeDados(endereco: String): String? {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco)).build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }


    fun buscaJogo(id: String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id";
        val json = consumeDados(endereco)
        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }

    fun buscaJogosJson(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consumeDados(endereco)

        val gson = Gson()
        val meuJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogo: List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)

        val listaJogoConvertida = listaJogo.map { infoJogoJson -> infoJogoJson.criaJogo() }

        return listaJogoConvertida
    }




    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json";
        val json = consumeDados(endereco)
        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)
        val listaGmerConvetida = listaGamer.map { infoGamerJson -> infoGamerJson.criaGamer() }

        return listaGmerConvetida
    }


}