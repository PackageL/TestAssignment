package com.test.testassignment.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BetTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testValidBet() {
        Bet bet = new Bet(1.0, 50);

        assertEquals(validator.validate(bet).size(), 0);
    }

    @Test
    void testInvalidBet() {
        Bet bet = new Bet(0.05, 50);

        assertEquals(validator.validate(bet).size(), 1);
    }

    @Test
    void testInvalidNumber() {
        Bet bet = new Bet(1.0, 101);

        assertEquals(validator.validate(bet).size(), 1);
    }

    @Test
    void testToString() {
        Bet bet = new Bet(1.0, 50);

        assertEquals(bet.toString(), "Bet{bet=1.0, number=50}");
    }
}
