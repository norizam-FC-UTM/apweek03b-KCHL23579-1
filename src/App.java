import java.util.Scanner;

class BankAccount {

    String name;
    double balance;
    double dividendRate; // example: 0.05 = 5%

    // Constructor
    public BankAccount(String name, double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
        this.dividendRate = 0.0;
    }

    // Deposit money
    public void deposit(double amount) {
        balance = balance + amount;
        // too simple - need refinement
    }

    // Withdraw money
    public void withdraw(double amount) {
        balance = balance - amount;
        // too simple - need refinement
    }

    // Calculate dividend
    public double calculateDividend() {
        return balance * dividendRate;
    }

    // Apply dividend to balance
    public void applyDividend() {
        double dividend = calculateDividend();
        balance = balance + dividend;
    }

    // Set dividend rate
    public void setDividendRate(double rate) {
        dividendRate = rate;
        // too simple - need refinement
    }

    // Display account information
    public void printObjectState() {
        System.out.println("\n===== ACCOUNT INFO =====");
        System.out.println("Name          : " + name);
        System.out.println("Balance       : RM " + balance);
        System.out.println("Dividend Rate : " + dividendRate * 100 + "%");
        System.out.println();
    }
}

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANK ACCOUNT SYSTEM =====");

        // Input
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial deposit: RM ");
        double initialDeposit = sc.nextDouble();

        // Create account
        BankAccount acc1 = new BankAccount(name, initialDeposit);

        System.out.println("\nAccount created successfully.");
        acc1.printObjectState();

        // Deposit
        System.out.println("----- DEPOSIT -----");
        System.out.print("Enter deposit amount: RM ");
        double depositAmount = sc.nextDouble();
        acc1.deposit(depositAmount);
        acc1.printObjectState();

        // Withdraw
        System.out.println("----- WITHDRAW -----");
        System.out.print("Enter withdrawal amount: RM ");
        double withdrawAmount = sc.nextDouble();
        acc1.withdraw(withdrawAmount);
        acc1.printObjectState();

        // Dividend
        System.out.println("----- YEAR-END DIVIDEND -----");
        System.out.print("Enter dividend rate (example 0.05 for 5%): ");
        double rate = sc.nextDouble();
        acc1.setDividendRate(rate);
        acc1.applyDividend();

        acc1.printObjectState();

        System.out.println("===== END OF PROGRAM =====");

        sc.close();
    }
}

/*
 * import java.util.Scanner;
 * 
 * class BankAccount {
 * 
 * String name;
 * double balance;
 * double dividentRate; // e.g. 0.03 = 3%
 * 
 * // Constructor
 * public BankAccount(String name, double initDeposit) {
 * this.name = name;
 * this.balance = initDeposit;
 * }
 * 
 * // Deposit money
 * public void deposit(double amount) {
 * balance = balance + amount;
 * }
 * 
 * // Withdraw money
 * public void withdraw(double amount) {
 * balance = balance - amount;
 * }
 * 
 * // Calculate divident
 * public double calculateDivident() {
 * return balance * dividentRate;
 * }
 * 
 * // Add divident into balance
 * public void applyDivident() {
 * double divident = calculateDivident();
 * balance += divident;
 * }
 * 
 * public void setDividentRate(double theRate) {
 * this.dividentRate = theRate;
 * }
 * 
 * // Display account info
 * public String printObjState() {
 * return "===== ACCOUNT INFO ===== \n" +
 * "Name          : " + name +
 * "Balance       : RM " + balance +
 * "Divident Rate : " + dividentRate * 100;
 * }
 * }
 * 
 * public class App {
 * public static void main(String[] args) throws Exception {
 * System.out.println("Hello, World!");
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * System.out.println("CREATING NEW BANK ACCOUNT");
 * System.out.print("Enter account holder name: ");
 * String name = sc.nextLine();
 * 
 * System.out.println("Enter initial deposit: ");
 * double initialDeposit = sc.nextDouble();
 * 
 * // Create account
 * BankAccount acc1 = new BankAccount(name, initialDeposit);
 * System.out.println("Acc Successfully created...initial deposit=RM" +
 * initialDeposit);
 * acc1.printObjState();
 * // Perform operations
 * System.out.println("\n--- PERFORMING TRANSACTIONS ---");
 * System.out.println("Enter amount Deposit RM...");
 * double depo = sc.nextDouble();
 * acc1.deposit(depo);
 * System.out.println(acc1.printObjState());
 * System.out.println("Enter amount Withdraw RM...");
 * double wd = sc.nextDouble();
 * acc1.withdraw(wd);
 * acc1.printObjState();
 * System.out.
 * println("\n\n\nEND OF 2026 - CALC DIVIDENT AT END OF FINANTIAL YEAR");
 * System.out.println("Enter div rate (ie 0.5 for 5%");
 * double theRate = sc.nextDouble();
 * acc1.setDividentRate(theRate);
 * acc1.applyDivident();
 * 
 * // Final output
 * acc1.printObjState();
 * 
 * sc.close();
 * }
 * }
 */