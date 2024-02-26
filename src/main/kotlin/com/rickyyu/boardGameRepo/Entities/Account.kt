package com.rickyyu.boardGameRepo.Entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Account(
    var login: String,
    var firstname: String,
    var lastname: String,
    @Id @GeneratedValue var id: Long? = null
    ) {

}