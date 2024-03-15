package br.com.alura.aluragames.dados

import br.com.alura.aluragames.modelo.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
     fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3309/alugames", "root", "lucas123")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }


}