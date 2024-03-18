package br.com.alura.aluragames.dados

import br.com.alura.aluragames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO( manager: EntityManager): DAO<Jogo>(manager) {

    override fun toEntity(objeto: Jogo) {
        return JogoEntity(objeto.titulo, objeto.capa,objeto.preco,objeto.descricao,objeto.id)
    }
    
       override fun getLista(): List<Jogo>{

                val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
                return query.resultList.map { entity ->
                    entity.descricao?.let {
                        Jogo(entity.titulo, entity.capa,entity.preco,
                            it, entity.id)
                    }!!
                }
        }






}