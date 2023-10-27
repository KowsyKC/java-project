package Mini_projects.Bank;

import java.util.ArrayList;

class Account {
    private static int accountCounter = 1;
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account(String accountHolderName, double balance) {
        this.accountNumber = accountCounter++;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            return true;
        }
        return false;
    }

    public void transfer(Account recipientAccount, double amount) {
        if (withdraw(amount)) {
            recipientAccount.deposit(amount);
            transactionHistory.add(new Transaction("Transfer to Account " + recipientAccount.getAccountNumber(), amount));
        } else {
            System.out.println("Transfer failed. Insufficient balance.");
        }
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
