//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package com.main;

import com.main.exceptions.*;

public class User implements Transaction{
    private Double balance;
    private String name;

    public User(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance >= 0){
            this.balance = balance;
        } else {
            throw new BalanceCannotBeNegativeException(balance);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public void deposit(double amount){
        if(amount <= 0) {
            throw new DepositCannotBeNegativeException(amount);
        } else {
            setBalance(balance + amount);
        }
    }
    @Override
    public double billAmount(double amount){
        if(amount <= 0) {
            throw new CannotBillWithNoChargeException();
        } else if(amount > balance) {
            throw new BillingAmountCannotExceedBalanceException(balance, amount);
        }
        return balance -= amount;
    }

    public void invalidInput() {
        throw new InvalidActionInputException();
    }
}
