package com.rickyyu.boardGameRepo.Services

import com.rickyyu.boardGameRepo.Entities.BoardGame
import com.rickyyu.boardGameRepo.Repositories.BoardGameRepository
import org.springframework.stereotype.Service

@Service
class BoardGameService(
    private val repository: BoardGameRepository
) {
    fun getAll(): List<BoardGame> {
        return repository.findAll().toList()
    }

    fun save(boardGame: BoardGame): BoardGame {
        return repository.save(boardGame)
    }

    fun findById(id: Long): BoardGame {
        return repository.findById(id).orElse(null)
    }

    fun findByName(name: String): BoardGame? {
        return repository.findByName(name)
    }
}