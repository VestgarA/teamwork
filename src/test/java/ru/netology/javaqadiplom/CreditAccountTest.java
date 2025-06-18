package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @ParameterizedTest
    @CsvSource({
            "-200,5000,15,-30",
            "200,5000,15,0",
            "0,5000,15,0"
    })
    public void PercentTest(int initialBalance, int creditLimit, int rate, int expected) {
        CreditAccount account = new CreditAccount(initialBalance, creditLimit, rate);
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }
}
