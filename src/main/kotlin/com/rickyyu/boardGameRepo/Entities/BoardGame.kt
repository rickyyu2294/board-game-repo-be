package com.rickyyu.boardGameRepo.Entities

import jakarta.persistence.*

@Entity
class BoardGame(

    var name: String,

    var description: String,

    var minPlayers: Int = 0,

    var maxPlayers: Int = 0,

    @OneToMany(mappedBy = "boardGame", cascade = [CascadeType.ALL], orphanRemoval = true)
    var accounts: Set<AccountBoardGame> = HashSet(),

    @Id @GeneratedValue
    var id: Long? = null
    ) {
//    override fun hashCode(): Int {
//        return Objects.hash(id, name)
//    }
//
//    override fun toString(): String {
//        return "$name $description"
//    }
}