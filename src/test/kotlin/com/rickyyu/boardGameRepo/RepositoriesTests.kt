package com.rickyyu.boardGameRepo

import com.rickyyu.boardGameRepo.Entities.BoardGame
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
    val boardGameRepository: BoardGameRepository
) {

    @Test
    fun `When findById then return board game`() {
        val game = BoardGame(
            name = "New Game",
            description = "This is a game",
            minPlayers = 2,
            maxPlayers = 4
        )

        testEntityManager.persist(game)
        testEntityManager.flush()

        val found = boardGameRepository.findByIdOrNull(game.id!!)!!
        assert(found == game)
    }
}