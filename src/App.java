import java.util.Scanner;

class BankAccount {

    String name;
    double balance;
    double dividendRate; // example: 0.05 = 5%
    String[] transacHistory;

    // Constructor
    public BankAccount(String name, double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
        this.dividendRate = 0.0;
        this.transacHistory = new String[90]; //for storage of 90 history
    }

    int idx = 0;

    public double getBalance()
    {
        return this.balance;
    }

    // Deposit money
    public void deposit(double amount) {
        balance = balance + amount;
        transacHistory[idx] = "Deposit"; 
        idx ++;
        // too simple - need refinement
    }

    // Withdraw money
    public void withdraw(double amount) {
        balance = balance - amount;
        transacHistory[idx] = "Withdraw";
        idx ++;
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
        transacHistory[idx] = "Add devident"; 
        idx ++;
    }

    public void printTransaction()
    {
        for (String elem:transacHistory)
            System.out.println(elem);
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

        int[] finMark = {88,75,60,80,90,95,77,91,77,80};
        // finMark[0] = 88

        for (int elem:finMark) // elem is name, any name also can
        {
            System.out.println(elem);
        }
        Scanner sc = new Scanner(System.in);

        BankAccount acc1 = new BankAccount("ALI", 1000.0);
        BankAccount acc2 = new BankAccount("BALI", 1500.0);
        BankAccount acc3 = new BankAccount("CALI", 1000.0);
        BankAccount acc4 = new BankAccount("DALI", 1500.0);
        BankAccount acc5 = new BankAccount("ELI", 1000.0);

        System.out.println(acc1);// beginning memory address
        System.out.println(acc2);
        System.out.println(acc3);

        acc3.deposit(575);
        acc3.applyDividend();
        acc3.setDividendRate(0.125);
        acc3.printObjectState();

        BankAccount[]accArr;
        accArr = new BankAccount[7];
        System.out.println(accArr);
        System.out.println(accArr[0]);
        System.out.println(accArr[1]);
        System.out.println(accArr[2]);
        System.out.println(accArr[3]);
        System.out.println(accArr[4]);

        accArr[0] = acc1;
        accArr[1] = acc2;
        accArr[2] = acc3;
        accArr[3] = new BankAccount("SITI", 500.0);
        accArr[4] = new BankAccount("SIVA", 100.00);
        accArr[5] = acc4;
        accArr[6] = acc5;

        accArr[3].deposit(700);
        accArr[4].withdraw(50);

        for(int i = 0; i < accArr.length; i++)
        {
            //print info of all accs
            accArr[i].printObjectState();
        }

        // end of year 2026, apply divid 7.5% to all accs
        for (int i = 0; i < 7; i++)
        {
            accArr[i].setDividendRate(0.075);
            accArr[i].applyDividend();
            accArr[i].printObjectState();
        }

        BankAccount highest = accArr[0]; // using enhanced loop
        for (BankAccount elem:accArr)
        {
            if (elem.getBalance() > highest.getBalance())
            {
                highest = elem;
            }
            System.out.println("Acc with highest balance is ");
            highest.printObjectState();
        }

        System.out.println("===== BANK ACCOUNT SYSTEM =====");

        sc.close();
    }
}

        // Input
/*         System.out.print("Enter account holder name: ");
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
*/

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