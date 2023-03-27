package com.test.testassignment.model;

import com.sun.istack.NotNull;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class Bet {

    @NotNull
    @DecimalMin(value = "0.1", message = "Bet amount should be at least 0.1")
    private Double bet;

    @NotNull
    @Min(value = 1, message = "Number should be between 1 and 100")
    @Max(value = 100, message = "Number should be between 1 and 100")
    private Integer number;

    public Double getBet() {
        return bet;
    }

    public void setBet(Double bet) {
        this.bet = bet;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "bet=" + bet +
                ", number=" + number +
                '}';
    }
}

