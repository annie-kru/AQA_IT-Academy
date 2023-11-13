package com.itacademy.aqa.lesson2.atm;

import com.itacademy.aqa.lesson2.card.impl.Card;
import com.itacademy.aqa.lesson2.card.impl.InsufficientFundsException;

import java.util.Scanner;

public class Atm {
    private Card card;
    public void start(Card card) {
        boolean flag = true;
        while(flag == true) {
            int operation = operationalMenu();
            switch (operation) {
                case 1:
                    System.out.println("Enter the deposit amount: >");
                    card.deposit(amountInput());
                    System.out.println("The balance has been replenished.");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw: >");
                    while (true) {
                        try {
                            card.withdraw(amountInput());
                            System.out.println("Please take the money.");
                            System.out.println();
                            break;
                        } catch (InsufficientFundsException e) {
                            System.out.println("Not enough money. Please try again.");
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the amount to withdraw: >");
                    while (true) {
                        try {
                            double amount = card.convert(amountInput(), 3.5);
                            card.withdraw(amount);
                            System.out.println("Please take the money.");
                            System.out.println();
                            break;
                        } catch (InsufficientFundsException e) {
                            System.out.println("Not enough money. Please try again.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Current balance is: " + card.showBalance());
                    System.out.println();

                    break;
                case 5:
                    System.out.println("Please do not forget your card in ATM.");
                    flag = false;
                    break;
            }
        }
    }

    private double amountInput(){
        double amount;
        while (true){
            Scanner sc = new Scanner(System.in);

            while (!sc.hasNextDouble()) {
                sc.nextLine();
                System.out.println("Invalid symbol. Please try again: >");
                System.out.print("> ");
            }
            amount = sc.nextDouble();
            if (amount > 0){
                break;
            } else {
                System.out.println("Invalid amount. Please try again: >");
            }
        }
        return amount;
    }
    private int operationalMenu(){
        Scanner sc = new Scanner(System.in);
        int operation;
        System.out.println("Choose the operation: "
                + "\n1. Deposit"
                + "\n2. Withdraw BYN"
                + "\n3. Withdraw USD"
                + "\n4. Show Balance"
                + "\n5. Return card");
        System.out.println();
        System.out.println("Please enter the number of operation: >");
        while (true) {
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Invalid symbol. Please try again: ");
                System.out.print("> ");
            }
            operation = sc.nextInt();
            if (operation >=1 && operation <= 5) {
                break;
            } else {
                System.out.println("Invalid operation number. Please try again: ");
                System.out.print("> ");
            }
        }
        return operation;
    }
}
