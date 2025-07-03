package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void ReplenishmentNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-1_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void ReplenishmentNull() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void purchaseWithinLimitsBalance() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void PurchaseAboveLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    //   @Test
    //   public void purchaseWithinCreditLimit() {
    //       CreditAccount account = new CreditAccount(
    //               0,
    //               5_000,
    //               15
    //       );
    //       account.pay(1_000);
    //
    //        account.yearChange();
    //       Assertions.assertEquals(-1_000, account.getBalance());
    //   }

    @Test
    public void calculatingInterestNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void calculatingInterestPositivBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
}














