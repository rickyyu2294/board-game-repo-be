package com.rickyyu.boardGameRepo.Controllers

import com.rickyyu.boardGameRepo.Entities.BoardGame
import com.rickyyu.boardGameRepo.Repositories.BoardGameRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardGameController(
    val repository: BoardGameRepository
) {

    @GetMapping("/boardgames")
    fun all(): List<BoardGame> {
        return repository.findAll().toList()
    }

    @PostMapping("/boardgames")
    fun addOneBoardGame(@RequestBody boardGame:BoardGame): BoardGame {
        return repository.save(boardGame)
    }
}