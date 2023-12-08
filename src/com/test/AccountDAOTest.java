package com.test;

import com.main.DAO.AccountDAO;
import com.main.model.Account;

public class AccountDAOTest {
    public static void runAccountDaoTest() {
        // Créez un objet Account pour tester
        Account accountToSave = new Account(1, "John Doe", 1000.0, 1, "Banque");

        // Créez une instance de la DAO
        AccountDAO accountDao = new AccountDAO();

        // Appelez la méthode save de la DAO
        Account savedAccount = accountDao.save(accountToSave);

        // Vérifiez si l'objet sauvegardé n'est pas nul
        if (savedAccount != null) {
            System.out.println("Account saved successfully with ID: " + savedAccount.getId());
        } else {
            System.out.println("Failed to save account.");
        }
    }
}
