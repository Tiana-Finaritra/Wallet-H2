import com.test.AccountDAOTest;
import com.test.DbConnectionTest;

public class Main {
    public static void main(String[] args) {
        DbConnectionTest.connectionDBTest();
        AccountDAOTest.runAccountDaoTest();
    }
}