/bank
   ├── Account.java  (Contains the Account class)
   ├── AccountExceptions.java (Custom exceptions)
Main.java (Executes transactions)
///////////////////////////////////////////////////////////////

// AccountExceptions.java

  package bank;

// Exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Exception for invalid deposit/withdrawal amount
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// Exception for account lockout after 3 incorrect PIN attempts
class AccountLockedException extends Exception {
    public AccountLockedException(String message) {
        super(message);
    }
}





// Account.java

package bank;

import java.util.Scanner;

public class Account {
    private double balance;
    private final int correctPIN = 1234; // Hardcoded for simplicity
    private int pinAttempts = 0;
    private boolean isLocked = false;

    // Constructor
    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero.");
        }
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    // Method to withdraw money with PIN authentication
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException, AccountLockedException {
        if (isLocked) {
            throw new AccountLockedException("Account is locked due to multiple incorrect PIN attempts.");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        int enteredPIN = scanner.nextInt();

        if (enteredPIN != correctPIN) {
            pinAttempts++;
            if (pinAttempts >= 3) {
                isLocked = true;
                throw new AccountLockedException("Too many incorrect PIN attempts! Account is now locked.");
            }
            System.out.println("Incorrect PIN. Remaining attempts: " + (3 - pinAttempts));
            return;
        }

        // Reset PIN attempts after a successful entry
        pinAttempts = 0;

        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Your balance is only $" + balance);
        }

        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
}




// Main.java

import bank.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account myAccount = new Account(500); // Initial balance: $500

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        myAccount.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        myAccount.withdraw(withdrawAmount);
                        break;

                    case 3:
                        myAccount.checkBalance();
                        break;

                    case 4:
                        System.out.println("Thank you for banking with us!");
                        return;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InvalidAmountException | InsufficientFundsException | AccountLockedException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                myAccount.checkBalance(); // Always show balance after transaction
            }
        }
    }
}





//sample execution

--- Bank Menu ---
1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Choose an option: 2
Enter withdrawal amount: $100
Enter PIN: 4321
Incorrect PIN. Remaining attempts: 2
Current balance: $500.0

--- Bank Menu ---
Choose an option: 2
Enter withdrawal amount: $100
Enter PIN: 1234
Withdrawn: $100
Current balance: $400.0

--- Bank Menu ---
Choose an option: 1
Enter deposit amount: $50
Deposited: $50
Current balance: $450.0

--- Bank Menu ---
Choose an option: 2
Enter withdrawal amount: $500
Enter PIN: 1234
Error: Insufficient funds! Your balance is only $450.0
Current balance: $450.0

--- Bank Menu ---
Choose an option: 2
Enter withdrawal amount: $50
Enter PIN: 4321
Incorrect PIN. Remaining attempts: 1
Current balance: $450.0

--- Bank Menu ---
Choose an option: 2
Enter withdrawal amount: $50
Enter PIN: 4321
Error: Too many incorrect PIN attempts! Account is now locked.
Current balance: $450.0

