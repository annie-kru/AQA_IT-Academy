package com.itacademy.aqa.lesson2.card.impl;

public class DebitCard extends Card {
    public DebitCard(String owner, double balance) {
        super(owner, balance);
    }

    public DebitCard(String owner) {
        super(owner);
    }

    @Override
    public double withdraw(double amount) throws InsufficientFundsException {
        if(amount < 0.0){
            throw new RuntimeException("Amount cannot be negative.");
        }
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            return getBalance();
        } else {
            throw new InsufficientFundsException("Insufficient funds");
        }
    }
}
