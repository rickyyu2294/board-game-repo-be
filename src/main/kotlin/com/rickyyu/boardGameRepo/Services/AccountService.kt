package com.rickyyu.boardGameRepo.Services

import com.rickyyu.boardGameRepo.Entities.Account
import com.rickyyu.boardGameRepo.Entities.AccountBoardGame
import com.rickyyu.boardGameRepo.Repositories.AccountBoardGameRepository
import com.rickyyu.boardGameRepo.Repositories.AccountRepository
import com.rickyyu.boardGameRepo.Repositories.BoardGameRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val boardGameRepository: BoardGameRepository,
    private val accountBoardGameRepository: AccountBoardGameRepository
) {
    fun getAllAccounts(): List<Account> {
        return accountRepository.findAll().toList()
    }

    fun saveAccount(account: Account): Account {
        return accountRepository.save(account)
    }

    fun findAccountById(id: Long): Account? {
        return accountRepository.findById(id).orElse(null)
    }

    fun findAccountByUsername(username: String): Account? {
        return accountRepository.findByUsername(username)
    }

    fun getBoardGamesForAccount(accountId: Long): List<AccountBoardGame> {
        return accountBoardGameRepository.findByAccountId(accountId)
    }

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