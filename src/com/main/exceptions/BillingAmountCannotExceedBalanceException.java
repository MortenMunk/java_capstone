package com.main.exceptions;

public class BillingAmountCannotExceedBalanceException extends RuntimeException {
    private double billAmount;
    private double balance;


    public BillingAmountCannotExceedBalanceException(double balance, double billAmount) {
        this.billAmount = billAmount;
        this.balance = balance;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public double getBalance() {
        return balance;
    }
}
