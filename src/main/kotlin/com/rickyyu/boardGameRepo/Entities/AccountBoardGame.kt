package com.rickyyu.boardGameRepo.Entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class AccountBoardGame(

    @ManyToOne
    val account: Account,

    @ManyToOne
    val boardGame: BoardGame,

    val timesPlayed: Int = 0,

    @Id @GeneratedValue val id: Long? = null
) {
}