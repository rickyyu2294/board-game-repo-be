package com.rickyyu.boardGameRepo.Controllers

import com.rickyyu.boardGameRepo.Entities.BoardGame
import com.rickyyu.boardGameRepo.Repositories.BoardGameRepository
import com.rickyyu.boardGameRepo.Services.BoardGameService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardGameController(
    val boardGameService: BoardGameService
) {

    @GetMapping("/boardgames")
    fun all(): List<BoardGame> {
        return boardGameService.getAll()
    }

    @PostMapping("/boardgames")
    fun addBoardGame(@RequestBody boardGame: BoardGame): BoardGame {
        return boardGameService.save(boardGame)
    }
}