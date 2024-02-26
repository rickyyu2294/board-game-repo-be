package com.rickyyu.boardGameRepo.Repositories

import com.rickyyu.boardGameRepo.Entities.Account
import com.rickyyu.boardGameRepo.Entities.AccountBoardGame
import org.springframework.data.repository.CrudRepository

interface AccountBoardGameRepository: CrudRepository<AccountBoardGame, Long> {
}