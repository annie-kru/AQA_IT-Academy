package com.itacademy.aqa.lesson2.card.impl;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String message){
        super(message);
    }
}
