package com.rickyyu.boardGameRepo.Controllers

import com.rickyyu.boardGameRepo.Entities.Account
import com.rickyyu.boardGameRepo.Entities.AccountBoardGame
import com.rickyyu.boardGameRepo.Services.AccountBoardGameService
import com.rickyyu.boardGameRepo.Services.AccountService
import org.springframework.web.bind.annotation.*

@RestController
class AccountController(
    private val accountService: AccountService,
    private val accountBoardGameService: AccountBoardGameService
) {
    @GetMapping("/accounts")
    fun getAccounts(): List<Account> {
        return accountService.getAll()
    }

    @PostMapping("/accounts")
    fun createAccount(@RequestBody account: Account): Account {
        return accountService.save(account)
    }

    @GetMapping("/accounts/{id}")
    fun getAccountByName(@PathVariable id: Long): Account? {
        return accountService.findById(id)
    }

    @GetMapping("/accounts/{id}/boardgames")
    fun getBoardGamesForAccount(@PathVariable id: Long): List<AccountBoardGame> {
        return accountBoardGameService.getBoardGamesForAccount(id)
    }
}