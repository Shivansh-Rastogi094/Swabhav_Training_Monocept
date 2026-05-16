package loanSystem;

public class CarLoan extends Loan implements LoanEligibility {

    public CarLoan(int id, String name, double amount, double rate)
            throws InvalidLoanException {

        super(id, name, amount, rate);
        System.out.println("CarLoan Constructor Called\n");
    }

    @Override
    public double calculateRepayment() {

        double interest = (principalAmount * interestRate * 5) / 100;
        return principalAmount + interest;
    }

    @Override
    public boolean checkEligibility(int creditScore, double income) {

        return creditScore >= 650 && income >= 30000;
    }
}
