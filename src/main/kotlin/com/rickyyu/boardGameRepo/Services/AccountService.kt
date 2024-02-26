package com.rickyyu.boardGameRepo.Services

import com.rickyyu.boardGameRepo.Entities.Account
import com.rickyyu.boardGameRepo.Entities.BoardGame
import com.rickyyu.boardGameRepo.Repositories.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val repository: AccountRepository
) {
    fun getAll(): List<Account> {
        return repository.findAll().toList()
    }

    fun save(account: Account): Account {
        return repository.save(account)
    }

    fun findById(id: Long): Account? {
        return repository.findById(id).orElse(null)
    }

    fun findByLogin(login: String): Account? {
        return repository.findByLogin(login)
    }
}