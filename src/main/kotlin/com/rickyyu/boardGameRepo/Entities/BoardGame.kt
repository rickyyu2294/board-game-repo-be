package com.rickyyu.boardGameRepo.Entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class BoardGame(
    val name: String,
    val description: String,
    val minPlayers: Int = 0,
    val maxPlayers: Int = 0,
    @Id @GeneratedValue var id: Long? = null
    ) {
//    override fun hashCode(): Int {
//        return Objects.hash(id, name)
//    }
//
//    override fun toString(): String {
//        return "$name $description"
//    }
}