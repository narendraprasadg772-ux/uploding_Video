import java.util.Scanner;

class Bank1 {
    void bankdetails() {
        System.out.println("Welcome to ABC Bank");
    }

    void rateofIntrest() {
        System.out.println("General rate of intrest is 5%");
    }
}

class Savingacc extends Bank1 {
    void acctype() {
        System.out.println("Savings bank account");
    }

    void rateofIntrest() {
        System.out.println("savingsacc rate of intrest is 7%");
    }

    void display() {
        System.out.println("Displaying");
    }
}

class Currentacc extends Bank1 {
    void acctype() {
        System.out.println("Current bank account");
    }

    void rateofIntrest() {
        System.out.println("Currentacc rate of intrest is 9%");
    }
}

class Employee {
    private double balance;
    private Bank1 account;

    public Employee(Bank1 account, double balance) {
        this.account = account;
        this.balance = balance;
    }

    public void chooseAccountType() {
        System.out.println("Choose account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            account = new Savingacc();
        } else if (choice == 2) {
            account = new Currentacc();
        } else {
            System.out.println("Invalid choice");
        }
    }

    public void credit(double amount) {
        balance += amount;
        System.out.println("Credited: " + amount);
        System.out.println("Current balance: " + balance);
    }

    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Debited: " + amount);
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public void rateofIntrest() {
        account.rateofIntrest();
    }

    public void displayAccountDetails() {
        account.bankdetails();
        account.acctype();
        account.rateofIntrest();
        if (account instanceof Savingacc) {
            ((Savingacc) account).display();
        }
    }
}

public class Bankn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = scanner.nextInt();
        Bank1 account;
        if (choice == 1) {
            account = new Savingacc();
        } else if (choice == 2) {
            account = new Currentacc();
        } else {
            System.out.println("Invalid choice");
            return;
        }

        Employee employee = new Employee(account, 1000.0);

        while (true) {
            System.out.println("1. Choose account type");
            System.out.println("2. Credit");
            System.out.println("3. Debit");
            System.out.println("4. Check balance");
            System.out.println("5. Rate of interest");
            System.out.println("6. Display account details");
            System.out.println("7. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    employee.chooseAccountType();
                    break;
                case 2:
                    System.out.println("Enter amount to credit:");
                    double creditAmount = scanner.nextDouble();
                    employee.credit(creditAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to debit:");
                    double debitAmount = scanner.nextDouble();
                    employee.debit(debitAmount);
                    break;
                case 4:
                    employee.checkBalance();
                    break;
                case 5:
                    employee.rateofIntrest();
                    break;
                case 6:
                    employee.displayAccountDetails();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}