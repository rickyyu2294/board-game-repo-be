package com.rickyyu.boardGameRepo.Controllers

import com.rickyyu.boardGameRepo.Entities.Account
import com.rickyyu.boardGameRepo.Services.AccountBoardGameService
import com.rickyyu.boardGameRepo.Services.AccountService
import org.springframework.web.bind.annotation.*

@RestController
class AccountController(
    private val accountService: AccountService,
    private val accountBoardGameService: AccountBoardGameService
) {
    @GetMapping("/accounts")
    fun all(): List<Account> {
        return accountService.getAll()
    }

    @PostMapping("/accounts")
    fun addAccount(@RequestBody account: Account): Account {
        return accountService.save(account)
    }

    @GetMapping("/accounts/{username}")
    fun getByName(@PathVariable username: String): Account? {
        return accountService.findByUsername(username)
    }
}