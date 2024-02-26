package com.rickyyu.boardGameRepo.Controllers

import com.rickyyu.boardGameRepo.Entities.Account
import com.rickyyu.boardGameRepo.Services.AccountService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class AccountController(
    private val accountService: AccountService
) {
    @GetMapping("/accounts")
    fun all(): List<Account> {
        return accountService.getAll()
    }

    @PostMapping("/accounts")
    fun addAccount(@RequestBody account: Account): Account {
        return accountService.save(account)
    }

    @GetMapping("/account/{login}")
    fun getByName(@PathVariable login: String): Account? {
        return accountService.findByLogin(login)
    }
}