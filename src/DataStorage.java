import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    private static final String PATH = "data/accounts.txt";

    public static List<Account> loadAccounts() {
        List<Account> accounts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                accounts.add(Account.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No saved accounts found.");
        }
        return accounts;
    }

    public static void saveAccounts(List<Account> accounts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH))) {
            for (Account ac : accounts) {
                writer.println(ac.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts.");
        }
    }
}
