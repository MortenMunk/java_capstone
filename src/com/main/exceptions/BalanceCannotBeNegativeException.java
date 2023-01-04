package com.main.exceptions;

public class BalanceCannotBeNegativeException extends RuntimeException{
    private double balance;

    public BalanceCannotBeNegativeException(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
