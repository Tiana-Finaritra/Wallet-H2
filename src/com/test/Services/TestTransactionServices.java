package com.test.Services;

import com.main.services.TransactionServices;
import java.time.LocalDateTime;

public class TestTransactionServices {
    public static void testGetBalanceAtDateTime() {
        int accountId = 1;

        LocalDateTime dateTime = LocalDateTime.of(2023, 11, 1, 12, 14);

        Double balance = TransactionServices.getBalanceAtDateTime(accountId, dateTime);
        System.out.println("Balance at " + dateTime + ": " + balance);
    }
}
