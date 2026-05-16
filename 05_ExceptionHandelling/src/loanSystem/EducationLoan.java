package loanSystem;

public class EducationLoan extends Loan implements LoanEligibility {

    public EducationLoan(int id, String name, double amount, double rate)
            throws InvalidLoanException {

        super(id, name, amount, rate);
        System.out.println("EducationLoan Constructor Called\n");
    }

    @Override
    public double calculateRepayment() {

        double interest = (principalAmount * interestRate * 3) / 100;
        return principalAmount + interest;
    }

    @Override
    public boolean checkEligibility(int creditScore, double income) {

        return creditScore >= 600;
    }
}
