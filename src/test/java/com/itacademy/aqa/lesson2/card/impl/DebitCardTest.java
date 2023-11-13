package com.itacademy.aqa.lesson2.card.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DebitCardTest {
    @Test
    public void testDebitCardCreationOwnerBalanceValid(){
        Card card = new DebitCard("John Doe", 100.00);
        assertEquals("Card{owner='John Doe', balance=100.0}",card.toString());
    }
    @Test
    public void testDebitCardCreationNullOwnerBalance(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            Card card = new DebitCard(null, 100.00);
        });
    }
    @Test
    public void testDebitCardCreationWithNegativeBalance(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            Card card = new DebitCard("John Doe", -100.00);
        });
    }
    @Test
    public void testDebitCardCreationOwner(){
        Card card = new DebitCard("John Doe");
        assertEquals("Card{owner='John Doe', balance=0.0}",card.toString());
    }
    @Test
    public void testDebitCardCreationNullOwner(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            Card card = new DebitCard(null);
        });
    }
    @Test
    public void testDebitCardDepositValid(){
        DebitCard card = new DebitCard("John Doe");
        card.deposit(100.0);
        assertEquals(100.0, card.getBalance());
    }
    @Test
    public void testDebitCardDepositNegative(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            DebitCard card = new DebitCard("John Doe");
            card.deposit(-100.0);
        });
    }
    @Test
    public void testDebitCardBalance(){
        DebitCard card = new DebitCard("John Doe",100.0);
        assertEquals(100.0, card.showBalance());
    }
    @Test
    public void testDebitCardConvertValid(){
        DebitCard card = new DebitCard("John Doe");
        assertEquals(30.0,card.convert(10.0,3.0));
    }
    @Test
    public void testDebitCardConvertNegativeAmount(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            DebitCard card = new DebitCard("John Doe");
            card.convert(-100.0, 3.0);
        });
    }
    @Test
    public void testDebitCardConvertNegativeRate(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            DebitCard card = new DebitCard("John Doe");
            card.convert(100.0, -3.0);
        });
    }
    @Test
    public void testDebitCardGetOwner(){
        DebitCard card = new DebitCard("John Doe");
        assertEquals("John Doe", card.getOwner());
    }
    @Test
    public void testDebitCardHashCode(){
        DebitCard card1 = new DebitCard("John Doe",100.0);
        DebitCard card2 = new DebitCard("John Doe",100.0);
        int hashCode1 = card1.hashCode();
        int hashCode2 = card2.hashCode();
        assertEquals(true,(hashCode1 == hashCode2));
    }
    @Test
    public void testDebitCardHashcodeNotEqual(){
        DebitCard card1 = new DebitCard("John Doe",100.0);
        DebitCard card2 = new DebitCard("Jane Doe",200.0);
        int hashCode1 = card1.hashCode();
        int hashCode2 = card2.hashCode();
        assertEquals(false,(hashCode1 == hashCode2));
    }
    @Test
    public void testDebitCardEquals(){
        DebitCard card1 = new DebitCard("John Doe",100.0);
        DebitCard card2 = new DebitCard("John Doe",100.0);
        assertEquals(true, card1.equals(card2));
    }
    @Test
    public void testDebitCardNotEquals(){
        DebitCard card1 = new DebitCard("John Doe",100.0);
        DebitCard card2 = new DebitCard("Jane Doe",200.0);
        assertEquals(false, card1.equals(card2));
    }
    @Test
     public void testValidWithdraw(){
        Card card = new DebitCard("John Doe", 100.00);
        Assertions.assertEquals(20.00,card.withdraw(80.00));
    }
    @Test
    public void testHigherWithdraw(){
       InsufficientFundsException thrown = Assertions.assertThrows(InsufficientFundsException.class, () -> {
           Card card = new DebitCard("John Doe", 100.00);
           card.withdraw(120.00);
        });
       Assertions.assertEquals("Insufficient funds", thrown.getMessage());
    }
    @Test
    public void testNegativeWithdraw(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            Card card = new DebitCard("John Doe",100.00);
            card.withdraw(-100);
        });
    }
}