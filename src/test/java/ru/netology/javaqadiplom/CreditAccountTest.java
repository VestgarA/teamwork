package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }


    @Test
    public void yearChange() {
        CreditAccount creditAccount = new CreditAccount(-200, 5000, 15);
        int expected = -30;
        int actual = creditAccount.yearChange();
        assertEquals (expected, actual);
    }

    @Test
    public void yearChange2() {
        CreditAccount creditAccount = new CreditAccount(200, 5000, 15);
        int expected = 0;
        int actual = creditAccount.yearChange();
        assertEquals(expected, actual);
    }

    @Test
    public void yearChange3() {
        CreditAccount creditAccount = new CreditAccount(0, 5000, 15);
        int expected = 0;
        int actual = creditAccount.yearChange();
        assertEquals(expected, actual);
    }
}
