package com.itacademy.aqa.lesson2.card.impl;

public class CreditCard extends Card {
    private double debt;
    public CreditCard(String owner, double balance, double debt) {
        super(owner, balance);
        this.debt = debt;
    }
    public CreditCard(String owner, double balance){
        super(owner, balance);
        this.debt = 100.00;
    }
    public CreditCard(String owner) {
        super(owner);
        this.debt = 100.00;
    }
    @Override
    public double withdraw(double amount)throws InsufficientFundsException {
        if(amount < 0.0){
            throw new RuntimeException("Amount cannot be negative.");
        }
        if (amount <= (getDebt() + getBalance())) {
            setBalance(getBalance() - amount);
            return getBalance();
        } else {
            throw new InsufficientFundsException("Overdraft limit is exceeded.");
        }
    }
    public double getDebt() {
        return debt;
    }
}
