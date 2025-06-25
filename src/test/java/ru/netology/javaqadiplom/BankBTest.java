package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankBTest {

    @Test
    public void transferFromOneAccountToAnother() {
        BankB bankB = new BankB();
        SavingAccount from = new SavingAccount(2000, 1000, 5000, 15);
        SavingAccount to = new SavingAccount(500, 0, 10000, 10);

        bankB.transfer(from, to, 1000);

        assertEquals(1000, from.getBalance());
        assertEquals(1500, to.getBalance());
    }

    @Test
    public void transferFromOneAccountToAnotherIsMoreThanTheMinBalance() {
        BankB bankB = new BankB();
        SavingAccount from = new SavingAccount(2000, 1000, 10000, 15);
        SavingAccount to = new SavingAccount(500, 0, 5000, 10);

        bankB.transfer(from, to, 1500);

        assertEquals(2000, from.getBalance());
        assertEquals(500, to.getBalance());
    }

    @Test
    public void transferFromOneAccountToAnotherIsMoreThanTheMaxBalance() {
        BankB bankB = new BankB();
        SavingAccount from = new SavingAccount(7000, 1000, 10000, 15);
        SavingAccount to = new SavingAccount(500, 0, 5000, 10);

        bankB.transfer(from, to, 6000);

        assertEquals(7000, from.getBalance());
        assertEquals(500, to.getBalance());
    }

    @Test
    public void replenishmentOfANegativeAmount() {
        BankB bankB = new BankB();
        SavingAccount from = new SavingAccount(7000, 1000, 10000, 15);
        SavingAccount to = new SavingAccount(500, 0, 5000, 10);

        bankB.transfer(from, to, -500);

        assertEquals(7000, from.getBalance());
        assertEquals(500, to.getBalance());
    }

    @Test
    public void toppingUpTheAmounOverTheLimit() {
        BankB bankB = new BankB();
        SavingAccount from = new SavingAccount(3000, 1000, 5000, 15);
        SavingAccount to = new SavingAccount(500, 0, 10000, 10);

        bankB.transfer(from, to, 6000);

        assertEquals(3000, from.getBalance());
        assertEquals(500, to.getBalance());
    }

}