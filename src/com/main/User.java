package com.main;

public class User implements Transaction {
    private Double balance;
    private String name;

    public User(String name, double balance) {
        super();
        this.balance = balance;
        this.name = name;
    }

    public User(String name) {
        super();
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
            String msg = "Balance must be positive";
            throw new IllegalArgumentException(msg);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public double deposit(double amount) {
        if(amount <= 0) {
            String msg = "Deposit amount must be positive";
            throw new IllegalArgumentException(msg);
        } else {
            setBalance(balance + amount);
        }
        return balance;
    }
    @Override
    public double billAmount(double amount) {
        if(amount <= 0) {
            String msg = "Billing amount must be greater than zero";
            throw new IllegalArgumentException(msg);
        } else if(amount > balance) {
            String msg = "Billing amount, must not exceed balance";
            throw new IllegalArgumentException(msg);
        }
        return balance -= amount;
    }
}
