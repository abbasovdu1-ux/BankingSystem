import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n==== Banking System ====");
            System.out.println("1. Create account");
            System.out.println("2. View balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Owner name: ");
                    String name = sc.nextLine();
                    Account acc = bank.createAccount(name);
                    System.out.println("Account created: " + acc.getAccountNumber());
                    break;

                case 2:
                    System.out.print("Account number: ");
                    Account a = bank.findAccount(sc.nextLine());
                    if (a == null) System.out.println("Not found.");
                    else System.out.println("Balance: " + a.getBalance());
                    break;

                case 3:
                    System.out.print("Account number: ");
                    Account d = bank.findAccount(sc.nextLine());
                    if (d == null) System.out.println("Not found.");
                    else {
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        d.deposit(amt);
                        DataStorage.saveAccounts(bank.getAllAccounts());
                    }
                    break;

                case 4:
                    System.out.print("Account number: ");
                    Account w = bank.findAccount(sc.nextLine());
                    if (w == null) System.out.println("Not found.");
                    else {
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        if (!w.withdraw(amt)) {
                            System.out.println("Not enough money.");
                        }
                        DataStorage.saveAccounts(bank.getAllAccounts());
                    }
                    break;

                case 5:
                    System.out.print("From: ");
                    String from = sc.nextLine();
                    System.out.print("To: ");
                    String to = sc.nextLine();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    if (bank.transfer(from, to, amount))
                        System.out.println("Transfer OK");
                    else
                        System.out.println("Transfer failed");
                    break;

                case 6:
                    System.out.println("Bye!");
                    return;
            }
        }
    }
}
