import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank() {
        this.accounts = DataStorage.loadAccounts();
    }

    public Account createAccount(String owner) {
        String accNumber = "ACC" + (accounts.size() + 1);
        Account account = new Account(owner, accNumber, 0.0);
        accounts.add(account);
        DataStorage.saveAccounts(accounts);
        return account;
    }

    public Account findAccount(String accNumber) {
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(accNumber))
                .findFirst()
                .orElse(null);
    }

    public boolean transfer(String from, String to, double amount) {
        Account a = findAccount(from);
        Account b = findAccount(to);

        if (a == null || b == null) return false;
        if (!a.withdraw(amount)) return false;

        b.deposit(amount);
        DataStorage.saveAccounts(accounts);
        return true;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }
}
