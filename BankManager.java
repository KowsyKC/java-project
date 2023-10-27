package Mini_projects.Bank;

import java.util.Scanner;

class BankManager {
    private Bank bank;
    public BankManager() {
        this.bank = new Bank();
    }
    private void displayMenu() {
        System.out.println("Bank Management System");
        System.out.println("1. Add Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. View Account Balance");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    public void start() {
        Scanner input = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getChoice(input);

            switch (choice) {
                case 1:
                    createAccount(input);
                    break;
                case 2:
                    performTransaction(input, TransactionType.DEPOSIT);
                    break;
                case 3:
                    performTransaction(input, TransactionType.WITHDRAW);
                    break;
                case 4:
                    performTransaction(input, TransactionType.TRANSFER);
                    break;

                case 5:
                    viewAccountBalance(input);
                    break;
                case 6:
                    System.out.println("Exiting... Thank you for using our services!");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int getChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getChoice(scanner);
        }
    }

    private Account getAccountFromUserInput(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = Integer.parseInt(scanner.nextLine().trim());
        Account account = bank.getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return null;
        }
        return account;
    }

    private void createAccount(Scanner scanner) {

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = Double.parseDouble(scanner.nextLine().trim());

        Account newAccount = new Account(accountHolderName, initialBalance);
        bank.addAccount(newAccount);
        System.out.println("Account created successfully!");
    }

    private void performTransaction(Scanner scanner, TransactionType type) {

        Account account = getAccountFromUserInput(scanner);

        if (account != null) {
            switch (type) {
                case DEPOSIT:
                    // Logic for deposit
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine().trim());
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. Current balance: " + account.getBalance());
                    break;

                case WITHDRAW:
                    // Logic for withdrawal
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawalAmount = Double.parseDouble(scanner.nextLine().trim());
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful. Current balance: " + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;

                case TRANSFER:
                    // Logic for transfer
                    System.out.print("Enter Destination Account Number: ");
                    int destinationAccountNumber = Integer.parseInt(scanner.nextLine().trim());
                    Account destinationAccount = bank.getAccount(destinationAccountNumber);

                    if (destinationAccount == null) {
                        System.out.println("Destination Account not found.");
                        return;
                    }

                    System.out.print("Enter Transfer Amount: ");
                    double transferAmount = Double.parseDouble(scanner.nextLine().trim());

                    if (account.withdraw(transferAmount)) {
                        destinationAccount.deposit(transferAmount);
                        System.out.println("Transfer successful. $" + transferAmount +
                                " transferred from Account " + account +
                                " to Account " + destinationAccountNumber);
                    } else {
                        System.out.println("Transfer failed. Insufficient balance.");
                    }
                    break;

                default:
                    System.out.println("Invalid transaction type.");
                    break;
            }
        }
    }
    private void viewAccountBalance(Scanner scanner) {
        // Implement logic to view account balance here
        // Modify this method accordingly based on your requirements.

        Account account = getAccountFromUserInput(scanner);

        if (account != null) {
            // Logic to view account balance
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder Name: " + account.getAccountHolderName());
            System.out.println("Current Balance: $" + account.getBalance());
        }
    }

    public static void main(String[] args) {
        BankManager bankManager = new BankManager();
        bankManager.start();
    }
}

enum TransactionType {
    DEPOSIT,
    WITHDRAW,
    TRANSFER
}