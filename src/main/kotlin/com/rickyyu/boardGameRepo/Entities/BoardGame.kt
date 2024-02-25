package com.rickyyu.boardGameRepo.Entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
class BoardGame(
    @Id @GeneratedValue var gameId: Long,
    val name: String,
    val description: String,
    val playCount: Int = 0,
    val minPlayers: Int = 0,
    val maxPlayers: Int = 0,
) {
//    override fun hashCode(): Int {
//        return Objects.hash(id, name)
//    }
//
//    override fun toString(): String {
//        return "$name $description"
//    }
}