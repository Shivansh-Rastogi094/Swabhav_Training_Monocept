package loanSystem;

public class HomeLoan extends Loan implements LoanEligibility {

	public HomeLoan(int id, String name, double amount, double rate) throws InvalidLoanException {

		super(id, name, amount, rate);
		System.out.println("HomeLoan Constructor Called\n");
	}

	public double calculateRepayment() {

		double interest = (principalAmount * interestRate * 10) / 100;
		return principalAmount + interest;
	}

	public boolean checkEligibility(int creditScore, double income) {

		return creditScore >= 700 && income >= 50000;
	}
}
