package com.rickyyu.boardGameRepo.Controllers

import com.rickyyu.boardGameRepo.Entities.Account
import com.rickyyu.boardGameRepo.Entities.AccountBoardGame
import com.rickyyu.boardGameRepo.Services.AccountService
import org.springframework.web.bind.annotation.*

@RestController
class AccountController(
    private val accountService: AccountService,
) {
    @GetMapping("/accounts")
    fun getAccounts(): List<Account> {
        return accountService.getAllAccounts()
    }

    @PostMapping("/accounts")
    fun createAccount(@RequestBody account: Account): Account {
        return accountService.saveAccount(account)
    }

    @GetMapping("/accounts/{id}")
    fun getAccountById(@PathVariable id: Long): Account? {
        return accountService.findAccountById(id)
    }

    @GetMapping("/accounts/{id}/boardgames")
    fun getBoardGamesForAccount(@PathVariable id: Long): List<AccountBoardGame> {
        return accountService.getBoardGamesForAccount(id)
    }

    @PostMapping("/accounts/{accountId}/boardgames/{boardGameId}")
    fun addBoardGameToAccount(
        @PathVariable accountId: Long,
        @PathVariable boardGameId: Long)
    : AccountBoardGame
    {
        return accountService.addBoardGameToAccount(accountId, boardGameId)
    }
}