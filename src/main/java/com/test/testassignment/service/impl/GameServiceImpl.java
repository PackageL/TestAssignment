package com.test.testassignment.service.impl;

import com.test.testassignment.model.Bet;
import com.test.testassignment.service.GameService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    @Override
    public Double playGame(Bet bet) {
        int randomNumber = new Random().nextInt(100) + 1;
        if (bet.getNumber() > randomNumber) {
            return bet.getBet() * (99.0 / (100.0 - bet.getNumber()));
        } else {
            return 0.0;
        }
    }
}
