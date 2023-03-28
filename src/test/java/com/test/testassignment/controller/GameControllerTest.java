package com.test.testassignment.controller;

import com.test.testassignment.model.Bet;
import com.test.testassignment.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class GameControllerTest {

    @Mock
    private GameService gameService;

    private GameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        gameController = new GameController(gameService);
    }

    @Test
    void playGame_shouldReturnWinAmountIfPlayerWins() {
        Bet bet = new Bet(10.0, 50);
        Double winAmount = 20.0;
        when(gameService.playGame(any(Bet.class))).thenReturn(winAmount);

        ResponseEntity<Double> response = gameController.playGame(bet);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(winAmount, response.getBody());
    }

}