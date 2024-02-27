package com.rickyyu.boardGameRepo

import com.rickyyu.boardGameRepo.Entities.Account
import com.rickyyu.boardGameRepo.Entities.AccountBoardGame
import com.rickyyu.boardGameRepo.Entities.BoardGame
import com.rickyyu.boardGameRepo.Repositories.AccountBoardGameRepository
import com.rickyyu.boardGameRepo.Repositories.AccountRepository
import com.rickyyu.boardGameRepo.Repositories.BoardGameRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val testEntityManager: TestEntityManager,
    val accountRepository: AccountRepository,
    val boardGameRepository: BoardGameRepository,
    val accountBoardGameRepository: AccountBoardGameRepository
) {

    private final val game = BoardGame(
        name = "New Game",
        description = "This is a game",
        minPlayers = 2,
        maxPlayers = 4
    )

    private final val account = Account(
        username = "johndoe",
        firstname = "John",
        lastname = "Doe"
    )

    private final val accountGame = AccountBoardGame(
        account = account,
        boardGame = game
    )

    @Test
    fun `When findById then return board game`() {
        testEntityManager.persist(game)
        testEntityManager.flush()

        val found = boardGameRepository.findByIdOrNull(game.id!!)!!
        assert(found == game)
    }

    @Test
    fun `When findByUsername then return account`() {
        testEntityManager.persist(account)
        testEntityManager.flush()

        val found = accountRepository.findByUsername(account.username)!!
        assert(found == account)
    }

    @Test
    fun `When addBoardGameToAccount then return account boardgames`() {
        testEntityManager.persist(game)
        testEntityManager.persist(account)
        testEntityManager.persist(accountGame)
        testEntityManager.flush()

        val found = accountBoardGameRepository.findByAccountId(account.id!!)
        assert(found.size == 1)
        assert(found.contains(accountGame))
    }
}