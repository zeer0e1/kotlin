package br.com.alura.aluragames.dados

import br.com.alura.aluragames.modelo.Jogo

class JogosDAO {
    fun getJogos(): List<Jogo> {
        val listaLojogos = mutableListOf<Jogo>()
        val conexao = Banco.obterConexao()

        if (conexao != null){
            try {
                val statement = conexao.createStatement()
                val resultado = statement.executeQuery("SELECT * FROM JOGOS")

                while (resultado.next()){
                    val id = resultado.getInt("id")
                    val titulo = resultado.getString("titulo")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val preco = resultado.getDouble("preco")

                    val jogo = Jogo(
                        titulo, capa, preco, descricao, id
                    )

                    listaLojogos.add(jogo)
                }

                statement.close()

            }finally {
                conexao.close()
            }
        }
        return  listaLojogos
    }

    fun adicionarJogo(jogo: Jogo) {
        val conexao = Banco.obterConexao()
        val insert = "INSERT INTO JOGOS (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"

        if (conexao != null){
            try {
                val statement = conexao.prepareStatement(insert)
                statement.setString(1,jogo.titulo)
                statement.setString(2,jogo.capa)
                statement.setDouble(3,jogo.preco)
                statement.setString(4,jogo.descricao)

                statement.executeUpdate()
                statement.close()
            }finally {
                conexao.close()
            }
        }
    }
}