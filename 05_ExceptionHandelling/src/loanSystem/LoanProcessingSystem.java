package loanSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanProcessingSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Loan> loans = new ArrayList<>();
        int choice = 0;

        do {

            try {

                System.out.println("\n===== Digital Loan Processing System =====");
                System.out.println("1. Apply for Home Loan");
                System.out.println("2. Apply for Car Loan");
                System.out.println("3. Apply for Education Loan");
                System.out.println("4. View All Loans");
                System.out.println("5. Process Loan Repayment & Eligibility");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next();
                    continue;
                }

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                    case 2:
                    case 3:

                        int id = readLoanID(loans);
                        String name = readBorrowerName();
                        double amount = readLoanAmount();
                        double rate = readInterestRate();

                        Loan loan = null;

                        if (choice == 1)
                            loan = new HomeLoan(id, name, amount, rate);

                        else if (choice == 2)
                            loan = new CarLoan(id, name, amount, rate);

                        else
                            loan = new EducationLoan(id, name, amount, rate);

                        loans.add(loan);

                        System.out.println("Loan created successfully!");
                        break;

                    case 4:

                        if (loans.isEmpty()) {
                            System.out.println("No loans found.");
                        } else {

                            for (Loan l : loans) {
                                l.displayLoan();
                            }
                        }

                        break;

                    case 5:

                        if (loans.isEmpty()) {
                            System.out.println("No loans available to process.");
                            break;
                        }

                        int credit = readCreditScore();
                        double income = readIncome();

                        for (Loan l : loans) {

                            l.displayLoan();

                            double repayment = l.calculateRepayment();

                            System.out.println("Total Repayment Amount: " + repayment);

                            LoanEligibility eligibility = (LoanEligibility) l;

                            if (eligibility.checkEligibility(credit, income))
                                System.out.println("Borrower Eligible");
                            else
                                System.out.println("Borrower Not Eligible");

                            System.out.println("----------------------------");
                        }

                        break;

                    case 6:
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid menu choice!");
                }

            } catch (InvalidLoanException e) {

                System.out.println("Loan Error: " + e.getMessage());

            } catch (InputMismatchException e) {

                System.out.println("Invalid datatype entered!");
                sc.nextLine();
            }

        } while (choice != 6);

        sc.close();
    }

 
    // INPUT VALIDATION METHODS
 
    static int readLoanID(ArrayList<Loan> loans) {

        while (true) {

            System.out.print("Enter Loan ID: ");

            if (!sc.hasNextInt()) {
                System.out.println("Loan ID must be numeric.");
                sc.next();
                continue;
            }

            int id = sc.nextInt();

            if (id <= 0) {
                System.out.println("Loan ID must be positive.");
                continue;
            }

            for (Loan l : loans) {
                if (l.loanId == id) {
                    System.out.println("Loan ID already exists!");
                    id = -1;
                    break;
                }
            }

            if (id != -1)
                return id;
        }
    }

    static String readBorrowerName() {

        sc.nextLine();

        while (true) {

            System.out.print("Enter Borrower Name: ");
            String name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                continue;
            }

            if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Name should contain only letters.");
                continue;
            }

            return name;
        }
    }

    static double readLoanAmount() {

        while (true) {

            System.out.print("Enter Loan Amount: ");

            if (!sc.hasNextDouble()) {
                System.out.println("Invalid amount.");
                sc.next();
                continue;
            }

            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Loan amount must be positive.");
                continue;
            }

            return amount;
        }
    }

    static double readInterestRate() {

        while (true) {

            System.out.print("Enter Interest Rate: ");

            if (!sc.hasNextDouble()) {
                System.out.println("Invalid interest rate.");
                sc.next();
                continue;
            }

            double rate = sc.nextDouble();

            if (rate <= 0 || rate > 100) {
                System.out.println("Interest rate must be between 0 and 100.");
                continue;
            }

            return rate;
        }
    }

    static int readCreditScore() {

        while (true) {

            System.out.print("Enter Credit Score (300-900): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid credit score.");
                sc.next();
                continue;
            }

            int credit = sc.nextInt();

            if (credit < 300 || credit > 900) {
                System.out.println("Credit score must be between 300 and 900.");
                continue;
            }

            return credit;
        }
    }

    static double readIncome() {

        while (true) {

            System.out.print("Enter Monthly Income: ");

            if (!sc.hasNextDouble()) {
                System.out.println("Invalid income.");
                sc.next();
                continue;
            }

            double income = sc.nextDouble();

            if (income <= 0) {
                System.out.println("Income must be positive.");
                continue;
            }

            return income;
        }
    }
}
