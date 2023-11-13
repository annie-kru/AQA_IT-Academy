package com.itacademy.aqa.lesson2.card.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditCardTest {
    @Test
    public void testCreditCardCreationOwnerBalanceValid(){
        Card card = new CreditCard("John Doe", 100.00);
        assertEquals("Card{owner='John Doe', balance=100.0}",card.toString());
    }
    @Test
    public void testCreditCardCreationNullOwnerBalance(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            Card card = new CreditCard(null, 100.00);
        });
    }
    @Test
    public void testCreditCardCreationWithNegativeBalance(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            Card card = new CreditCard("John Doe", -100.00);
        });
    }
    @Test
    public void testCreditCardCreationOwner(){
        CreditCard card = new CreditCard("John Doe");
        assertEquals("Card{owner='John Doe', balance=0.0}",card.toString());
        assertEquals(100.0,card.getDebt());
    }
    @Test
    public void testCreditCardCreationNullOwner(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            Card card = new CreditCard(null);
        });
    }
    @Test
    public void testCreditCardDepositValid(){
        CreditCard card = new CreditCard("John Doe");
        card.deposit(100.0);
        assertEquals(100.0, card.getBalance());
    }
    @Test
    public void testCreditCardDepositNegative(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CreditCard card = new CreditCard("John Doe");
            card.deposit(-100.0);
        });
    }
    @Test
    public void testCreditCardBalance(){
        CreditCard card = new CreditCard("John Doe",100.0);
        assertEquals(100.0, card.showBalance());
    }
    @Test
    public void testCreditCardConvertValid(){
        CreditCard card = new CreditCard("John Doe");
        assertEquals(30.0,card.convert(10.0,3.0));
    }
    @Test
    public void testCreditCardConvertNegativeAmount(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CreditCard card = new CreditCard("John Doe");
            card.convert(-100.0, 3.0);
        });
    }
    @Test
    public void testCreditCardConvertNegativeRate(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CreditCard card = new CreditCard("John Doe");
            card.convert(100.0, -3.0);
        });
    }
    @Test
    public void testCreditCardGetOwner(){
        CreditCard card = new CreditCard("John Doe");
        assertEquals("John Doe", card.getOwner());
    }
    @Test
    public void testCreditCardHashCode(){
        CreditCard card1 = new CreditCard("John Doe",100.0);
        CreditCard card2 = new CreditCard("John Doe",100.0);
        int hashCode1 = card1.hashCode();
        int hashCode2 = card2.hashCode();
        assertEquals(true,(hashCode1 == hashCode2));
    }
    @Test
    public void testCreditCardHashcodeNotEqual(){
        CreditCard card1 = new CreditCard("John Doe",100.0);
        CreditCard card2 = new CreditCard("Jane Doe",200.0);
        int hashCode1 = card1.hashCode();
        int hashCode2 = card2.hashCode();
        assertEquals(false,(hashCode1 == hashCode2));
    }
    @Test
    public void testCreditCardEquals(){
        CreditCard card1 = new CreditCard("John Doe",100.0);
        CreditCard card2 = new CreditCard("John Doe",100.0);
        assertEquals(true, card1.equals(card2));
    }
    @Test
    public void testCreditCardNotEquals(){
        CreditCard card1 = new CreditCard("John Doe",100.0);
        CreditCard card2 = new CreditCard("Jane Doe",200.0);
        assertEquals(false, card1.equals(card2));
    }
    @Test
    public void testCreditCardCreationFull(){
        CreditCard card = new CreditCard("John Doe",200.00,150.00);
        assertEquals("Card{owner='John Doe', balance=200.0}",card.toString());
        assertEquals(150.0,card.getDebt());
    }
    @Test
    public void testCreditCardWithdrawValid(){
        CreditCard card = new CreditCard("John Doe",200.00,150.00);
        card.withdraw(300.00);
        assertEquals(-100.0,card.getBalance());
    }
    @Test
    public void testCreditCardWithdrawNegativeAmount(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CreditCard card = new CreditCard("John Doe");
            card.withdraw(-100.0);
        });
    }
    @Test
    public void testCreditCardHigherWithdraw(){
        InsufficientFundsException thrown = Assertions.assertThrows(InsufficientFundsException.class, () -> {
            CreditCard card = new CreditCard("John Doe", 100.00,200);
            card.withdraw(330.00);
        });
        Assertions.assertEquals("Overdraft limit is exceeded.", thrown.getMessage());
    }


}