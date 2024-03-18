package br.com.alura.aluragames.dados

import br.com.alura.aluragames.modelo.Gamer
import javax.persistence.EntityManager

class GamersDAO(val manager: EntityManager) {

    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { entity -> Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario, entity.id) }
    }

    fun adicionarGamer(gamer: Gamer){
        val entity = gamer.dataNascimento?.let { gamer.usuario?.let { it1 ->
            GamerEntity(gamer.id, gamer.nome, gamer.email, it,
                it1
            )
        } }
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

}