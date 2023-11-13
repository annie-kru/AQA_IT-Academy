package com.itacademy.aqa.lesson2;

import com.itacademy.aqa.lesson2.atm.Atm;
import com.itacademy.aqa.lesson2.card.impl.Card;
import com.itacademy.aqa.lesson2.card.impl.CreditCard;
import com.itacademy.aqa.lesson2.card.impl.DebitCard;

public class Main {
    public static void main(String[] args) {
        Card card1 = new DebitCard("John Doe", 1000);
        Card card2 = new CreditCard("Jennie Smith", 200);

        Atm atm = new Atm();
       atm.start(card1);


    }
}
