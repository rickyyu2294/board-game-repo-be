package com.rickyyu.boardGameRepo.Services

import com.rickyyu.boardGameRepo.Entities.AccountBoardGame
import com.rickyyu.boardGameRepo.Repositories.AccountBoardGameRepository
import com.rickyyu.boardGameRepo.Repositories.AccountRepository
import com.rickyyu.boardGameRepo.Repositories.BoardGameRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AccountBoardGameService(
    private val accountRepository: AccountRepository,
    private val boardGameRepository: BoardGameRepository,
    private val accountBoardGameRepository: AccountBoardGameRepository
) {
   @Transactional
   fun addBoardGameToAccount(accountId: Long, boardGameId: Long): AccountBoardGame {
       val account = accountRepository.findById(accountId).orElseThrow()
       val boardGame = boardGameRepository.findById(boardGameId).orElseThrow()

       val accountBoardGame = AccountBoardGame(
           account = account,
           boardGame = boardGame
       )

       return accountBoardGameRepository.save(accountBoardGame)
   }
}