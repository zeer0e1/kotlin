package br.com.alura.aluragames.principal

import br.com.alura.aluragames.modelo.Periodo
import br.com.alura.aluragames.modelo.PlanoAssinatura
import br.com.alura.aluragames.services.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogoJson = consumo.buscaJogosJson()

    val gamerCaroline = listaGamers[3]
    val jogoRed = listaJogoJson[3]
    val jogoHomemAranha = listaJogoJson[13]
    val jogoBioshock = listaJogoJson[15]
    val jogoAleatorio = listaJogoJson[7]

    jogoHomemAranha.recomendar(10)
    jogoHomemAranha.recomendar(5)
    jogoHomemAranha.recomendar(9)


    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(14))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(6))

    gamerCaroline.alugaJogo(jogoRed, periodo)
    gamerCaroline.alugaJogo(jogoHomemAranha, periodo2)
    gamerCaroline.alugaJogo(jogoBioshock, periodo3)

    val gamerCamila = listaGamers[5]
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 9.0)

    gamerCamila.alugaJogo(jogoRed, periodo)
    gamerCamila.alugaJogo(jogoHomemAranha, periodo2)
    gamerCamila.alugaJogo(jogoBioshock, periodo3)
    gamerCamila.alugaJogo(jogoBioshock, periodo3)
    gamerCamila.alugaJogo(jogoAleatorio, periodo3)
    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(10)
    gamerCamila.recomendar(7)
    gamerCamila.recomendar(8)
//    println(gamerCamila.alugaJogo(jogoRed,periodo))

    gamerCamila.recomendarJogo(jogoRed, 10)
    gamerCamila.recomendarJogo(jogoHomemAranha, 9)

    gamerCaroline.recomendarJogo(jogoRed, 10)

    val jogoResidentVillage = listaJogoJson[10]
    val jogoSpider = listaJogoJson[13]
    val jogoTheLastOfUs = listaJogoJson[2]
    val jogoDandara = listaJogoJson[5]
    val jogoAssassins = listaJogoJson[4]
    val jogoCyber = listaJogoJson[6]
    val jogoGod = listaJogoJson[7]
    val jogoSkyrim = listaJogoJson[18]

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)


}