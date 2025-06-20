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
    public void whenDepositingTheAmountWillBeMoreThanTheMaxBalance() {
        SavingAccount account = new SavingAccount(
                6_000,
                1_000,
                10_000,
                5
        );

        account.add(5_000);

        Assertions.assertEquals(6_000, account.getBalance());
    }

    @Test
    public void replenishmentForANegativeAmount() {
        SavingAccount account = new SavingAccount(
                6_000,
                1_000,
                10_000,
                5
        );

        account.add(-1_000);

        Assertions.assertEquals(6_000, account.getBalance());
    }

    @Test
    public void replenishmentToTheMaxBalance() {
        SavingAccount account = new SavingAccount(
                6_000,
                1_000,
                10_000,
                5
        );

        account.add(4_000);

        Assertions.assertEquals(10_000, account.getBalance());
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

        savingAccount.pay(2000);


        assertEquals(5000 - 2000, savingAccount.getBalance());
    }

    @Test
    public void purchaseMoreThanTheRemainingBalance() {
        SavingAccount savingAccount = new SavingAccount(
                4000,
                1000,
                10000,
                15);

        savingAccount.pay(6000);

        assertEquals(4000, savingAccount.getBalance());
    }

    @Test
    public void purchaseEqualToTheBalance() {
        SavingAccount savingAccount = new SavingAccount(
                5000,
                1000,
                10000,
                15);

        savingAccount.pay(5000);

        assertEquals(5000, savingAccount.getBalance());
    }

    @Test
    public void purchaseMoreThanTheMinBalance() {
        SavingAccount savingAccount = new SavingAccount(
                5000,
                1000,
                10000,
                15);

        savingAccount.pay(4500);

        assertEquals(5000, savingAccount.getBalance());
    }

    @Test
    public void purchaseForANegativeAmount() {
        SavingAccount savingAccount = new SavingAccount(
                5000,
                1000,
                10000,
                15);

        savingAccount.pay(-1000);

        assertEquals(5000, savingAccount.getBalance());
    }

    @Test
    public void buyingAccordingToAllTheRulesMin() {
        SavingAccount savingAccount = new SavingAccount(
                5000,
                1000,
                10000,
                15);

        savingAccount.pay(4000);


        assertEquals(1000, savingAccount.getBalance());
    }

    @Test
    public void percent() {
        SavingAccount savingAccount = new SavingAccount(
                200,
                1000,
                5000,
                15
        );

        assertEquals(30, savingAccount.yearChange());
    }

}