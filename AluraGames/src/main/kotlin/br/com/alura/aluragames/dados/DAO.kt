package br.com.alura.aluragames.dados

import javax.persistence.EntityManager

abstract class DAO <TModel>(protected val manager: EntityManager) {

    abstract fun toEntity(objeto: TModel)
    abstract fun getLista(): List<TModel>
    open fun adiconar(objeto: TModel){
        val entity = toEntity(objeto)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}