package com.itacademy.aqa.lesson2.card;

public interface Cardable {
    double showBalance();
    double deposit(double amount);
    double withdraw(double amount);
    double convert(double amount, double exchangeRate);
}
