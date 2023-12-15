package com.test.DAO;

import com.main.DAO.CurrencyDAO;
import com.main.model.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDAOTest {
    public static void runCurrencySaveTest() {
        System.out.println("\n============= save TEST ===========");
        Currency currencyToSave = new Currency(1, "Euro", "EUR");
        CurrencyDAO currencyDao = new CurrencyDAO();
        Currency savedCurrency = currencyDao.save(currencyToSave);

        if (savedCurrency != null) {
            System.out.println("==> Currency saved successfully with ID: " + savedCurrency.getId());
        } else {
            System.out.println("==> Failed to save currency.");
        }
        System.out.println("--");
    }

    public static void runCurrencySaveAllTest() {
        System.out.println("\n============= saveAll TEST ===========");
        List<Currency> currenciesToSave = new ArrayList<>();
        currenciesToSave.add(new Currency(1, "Euro", "EUR"));
        currenciesToSave.add(new Currency(2, "US Dollar", "USD"));

        CurrencyDAO currencyDao = new CurrencyDAO();
        List<Currency> savedCurrencies = currencyDao.saveAll(currenciesToSave);

        if (!savedCurrencies.isEmpty()) {
            System.out.println("==> Currencies saved successfully:");
            for (Currency savedCurrency : savedCurrencies) {
                System.out.println("\tID: " + savedCurrency.getId());
            }
        } else {
            System.out.println("==> Failed to save currencies.");
        }
        System.out.println("--");
    }

    public static void runCurrencyFindAllTest() {
        System.out.println("\n============= findAll TEST ===========");
        CurrencyDAO currencyDao = new CurrencyDAO();
        List<Currency> currencies = currencyDao.findAll();

        if (!currencies.isEmpty()) {
            System.out.println("==> Currencies found:");
            for (Currency currency : currencies) {
                System.out.println("\tID: " + currency.getId() + ", Name: " + currency.getName() + ", Code: " + currency.getCode());
            }
        } else {
            System.out.println("==> No currencies found.");
        }
        System.out.println("--");
    }

    public static void runCurrencyDeleteTest() {
        System.out.println("\n============= delete TEST ===========");
        CurrencyDAO currencyDao = new CurrencyDAO();
        Currency currencyToDelete = new Currency(1, "Euro", "EUR");

        Currency deletedCurrency = currencyDao.delete(currencyToDelete);

        if (deletedCurrency != null) {
            System.out.println("==> Currency deleted successfully with ID: " + deletedCurrency.getId());
        } else {
            System.out.println("==> Failed to delete currency.");
        }
        System.out.println("--");
    }
}
