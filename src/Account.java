public class Account {
    private String owner;
    private String accountNumber;
    private double balance;

    public Account(String owner, String accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return owner + ";" + accountNumber + ";" + balance;
    }

    public static Account fromString(String data) {
        String[] parts = data.split(";");
        return new Account(parts[0], parts[1], Double.parseDouble(parts[2]));
    }
}
