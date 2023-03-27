package com.test.testassignment.controller;

import com.test.testassignment.model.Bet;
import com.test.testassignment.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Double> playGame(@RequestBody @Valid Bet bet) {
        Double winAmount = gameService.playGame(bet);
        return ResponseEntity.ok(winAmount);
    }
}

