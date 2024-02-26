package com.rickyyu.boardGameRepo.Repositories

import com.rickyyu.boardGameRepo.Entities.BoardGame
import org.springframework.data.repository.CrudRepository

interface BoardGameRepository: CrudRepository<BoardGame, Long> {
    fun findByName(name: String): BoardGame
}