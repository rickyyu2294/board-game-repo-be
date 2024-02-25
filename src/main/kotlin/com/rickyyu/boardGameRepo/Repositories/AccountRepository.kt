package com.rickyyu.boardGameRepo.Repositories

import com.rickyyu.boardGameRepo.Entities.Account
import org.springframework.data.repository.CrudRepository

interface AccountRepository: CrudRepository<Account, Long> {
}