package com.itacademy.aqa.lesson2.card.impl;

import com.itacademy.aqa.lesson2.card.Cardable;

import java.util.Objects;

public abstract class Card implements Cardable {
    private String owner;
    private double balance;

    public Card(String owner, double balance) {
        if (owner == null){
            throw new RuntimeException("Owner cannot be null or empty.");
        }
        this.owner = owner;
        if(balance < 0.0){
            throw new RuntimeException("Balance cannot be negative.");
        }
        this.balance = balance;
    }
    public Card(String owner) {
        if (owner == null){
            throw new RuntimeException("Owner cannot be null or empty.");
        }
        this.owner = owner;
        this.balance = 0.0;
    }
    public double deposit(double amount) {
        if(amount < 0.0){
            throw new RuntimeException("Deposit cannot be negative.");
        }
        setBalance(getBalance() + amount);
        return getBalance();
    }

    public double showBalance() {
        return getBalance();
    }
    public double convert(double amountUSD, double exchangeRate) {
        if(amountUSD < 0.0){
            throw new RuntimeException("USD amount cannot be negative.");
        }
        if(exchangeRate < 0.0){
            throw new RuntimeException("Exchange rate cannot be negative.");
        }
        return amountUSD * exchangeRate;
    }
    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Double.compare(card.balance, balance) == 0 && Objects.equals(owner, card.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, balance);
    }

    @Override
    public String toString() {
        return "Card{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
