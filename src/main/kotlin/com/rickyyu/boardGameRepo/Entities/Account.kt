package com.rickyyu.boardGameRepo.Entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Account(

    var username: String,

    var firstname: String,

    var lastname: String,

    @JsonIgnore
    @OneToMany(mappedBy = "account", cascade = [CascadeType.ALL], orphanRemoval = true)
    var boardGames: Set<AccountBoardGame> = HashSet(),

    @Id @GeneratedValue
    var id: Long? = null
    ) {

}