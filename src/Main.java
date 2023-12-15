import com.test.Services.TestTransactionServices;
import com.test.DAO.TestTerminalView;

public class Main {
    public static void main(String[] args) {
        TestTerminalView.AllDAOTestAccount();
        TestTerminalView.AllDAOTestCurrency();
        TestTerminalView.AllDAOTestTransaction();
        TestTerminalView.AllDAOTestAccountTransaction();
        TestTerminalView.AllDAOTestTransactionCategory();
        TestTransactionServices.testGetBalanceAtDateTime();
    }
}