package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void constructorInvalidParameters() {
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(3000, 1000, 10000, -15));
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2000, 5000, 3000, 15));
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(3000, -1000, 5000, 10));
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2000, 1000, -10000, 10));
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(10000, 1000, 5000, 25));
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(-1000, 1000, 5000, 25));
    }

    @Test
    public void buyingAccordingToAllTheRules() {
        SavingAccount savingAccount = new SavingAccount(
                5000,
                1000,
                10000,
                15);

        assertTrue(savingAccount.pay(2000));

        assertEquals(5000 - 2000, savingAccount.getBalance());
    }

    @Test
    public void purchaseMoreThanTheRemainingBalance() {
        SavingAccount savingAccount = new SavingAccount(
                4000,
                1000,
                10000,
                15);

        assertFalse(savingAccount.pay(6000));

        assertEquals(4000, savingAccount.getBalance());
    }

}