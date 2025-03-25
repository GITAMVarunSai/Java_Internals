import java.util.ArrayList;
import java.util.List;

// Account class representing an individual bank account
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Override toString for display
    @Override
    public String toString() {
        return "Account{Account Number='" + accountNumber + "', Holder='" + accountHolder + "', Balance=" + balance + "}";
    }
}

// Bank class to manage multiple accounts
class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // Method to add an account
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added: " + account.getAccountHolder());
    }

    // Method to remove an account by account number
    public void removeAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                accounts.remove(acc);
                System.out.println("Account removed: " + acc.getAccountHolder());
                return;
            }
        }
        System.out.println("Account with number " + accountNumber + " not found.");
    }

    // Method to find an account by account number
    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    // Display all accounts
    public void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the bank.");
        } else {
            System.out.println("Bank Accounts:");
            for (Account acc : accounts) {
                System.out.println(acc);
            }
        }
    }
}

// Main class to test the Bank system
public class BankManager {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Creating accounts
        Account acc1 = new Account("1001", "Alice", 5000);
        Account acc2 = new Account("1002", "Bob", 3000);
        Account acc3 = new Account("1003", "Charlie", 7000);

        // Adding accounts to the bank
        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(acc3);

        // Displaying accounts
        bank.displayAccounts();

        // Performing transactions
        Account account = bank.findAccount("1002");
        if (account != null) {
            account.deposit(1500);
            account.withdraw(2000);
        }

        // Removing an account
        bank.removeAccount("1001");

        // Displaying accounts after removal
        bank.displayAccounts();
    }
}
