package com.test.testassignment.service.impl;

import com.test.testassignment.model.Bet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.mockito.Mockito.when;

class GameServiceImplTest {

    @Mock
    private Random random;

    @InjectMocks
    private GameServiceImpl gameService;

    @Test
    void playGame_shouldReturnWinAmount_whenPlayerWins() {
        MockitoAnnotations.openMocks(this);

        Bet bet = new Bet();
        bet.setBet(40.5);
        bet.setNumber(99);

        when(random.nextInt(100)).thenReturn(49);

        double winAmount = gameService.playGame(bet);

        Assertions.assertEquals(4009.5, winAmount, 0.01);
    }

    @Test
    void playGame_shouldReturnZero_whenPlayerLoses() {
        MockitoAnnotations.openMocks(this);

        Bet bet = new Bet();
        bet.setBet(10.0);
        bet.setNumber(1);

        when(random.nextInt(100)).thenReturn(51);

        double winAmount = gameService.playGame(bet);

        Assertions.assertEquals(0.0, winAmount, 0.01);
    }
}



