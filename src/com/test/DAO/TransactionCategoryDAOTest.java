package com.test.DAO;

import com.main.DAO.TransactionCategoryDAO;
import com.main.model.TransactionCategory;

import java.util.ArrayList;
import java.util.List;

public class TransactionCategoryDAOTest {
    public static void runTransactionCategorySaveTest() {
        System.out.println("\n============= save TEST ===========");
        TransactionCategory categoryToSave = new TransactionCategory(1, "Groceries", "Milk, Bread, Eggs");
        TransactionCategoryDAO categoryDao = new TransactionCategoryDAO();
        TransactionCategory savedCategory = categoryDao.save(categoryToSave);

        if (savedCategory != null) {
            System.out.println("==> Transaction category saved successfully with ID: " + savedCategory.getId());
        } else {
            System.out.println("==> Failed to save transaction category.");
        }
        System.out.println("--");
    }

    public static void runTransactionCategorySaveAllTest() {
        System.out.println("\n============= saveAll TEST ===========");
        List<TransactionCategory> categoriesToSave = new ArrayList<>();
        categoriesToSave.add(new TransactionCategory(1, "Groceries", "Milk, Bread, Eggs"));
        categoriesToSave.add(new TransactionCategory(2, "Entertainment", "Movie, Concert"));

        TransactionCategoryDAO categoryDao = new TransactionCategoryDAO();
        List<TransactionCategory> savedCategories = categoryDao.saveAll(categoriesToSave);

        if (!savedCategories.isEmpty()) {
            System.out.println("==> Transaction categories saved successfully:");
            for (TransactionCategory savedCategory : savedCategories) {
                System.out.println("\tID: " + savedCategory.getId());
            }
        } else {
            System.out.println("==> Failed to save transaction categories.");
        }
        System.out.println("--");
    }

    public static void runTransactionCategoryFindAllTest() {
        System.out.println("\n============= findAll TEST ===========");
        TransactionCategoryDAO categoryDao = new TransactionCategoryDAO();
        List<TransactionCategory> categories = categoryDao.findAll();

        if (!categories.isEmpty()) {
            System.out.println("==> Transaction categories found:");
            for (TransactionCategory category : categories) {
                System.out.println("\tID: " + category.getId() + ", Name: " + category.getName() + ", Items List: " + category.getItemsList());
            }
        } else {
            System.out.println("==> No transaction categories found.");
        }
        System.out.println("--");
    }

    public static void runTransactionCategoryDeleteTest() {
        System.out.println("\n============= delete TEST ===========");
        TransactionCategoryDAO categoryDao = new TransactionCategoryDAO();
        // Assuming you have an existing category to delete
        TransactionCategory categoryToDelete = new TransactionCategory(1, "Groceries", "Milk, Bread, Eggs");

        TransactionCategory deletedCategory = categoryDao.delete(categoryToDelete);

        if (deletedCategory != null) {
            System.out.println("==> Transaction category deleted successfully with ID: " + deletedCategory.getId());
        } else {
            System.out.println("==> Failed to delete transaction category.");
        }
        System.out.println("--");
    }

    public static void main(String[] args) {
        runTransactionCategorySaveTest();
        runTransactionCategorySaveAllTest();
        runTransactionCategoryFindAllTest();
        runTransactionCategoryDeleteTest();
    }
}
