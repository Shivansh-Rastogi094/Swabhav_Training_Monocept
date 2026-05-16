package loanSystem;

public abstract class Loan {

	protected int loanId;
	protected String borrowerName;
	protected double principalAmount;
	protected double interestRate;

	static {
		System.out.println("Loading Loan Processing System Configuration...");
		System.out.println("Loan system initialized.\n");
	}

	public Loan(int loanId, String borrowerName, double principalAmount, double interestRate)
			throws InvalidLoanException {

		System.out.println("Loan Constructor Called");

		if (principalAmount <= 0) {
			throw new InvalidLoanException("Loan amount must be positive.");
		}

		if (interestRate <= 0) {
			throw new InvalidLoanException("Interest rate must be positive.");
		}

		this.loanId = loanId;
		this.borrowerName = borrowerName;
		this.principalAmount = principalAmount;
		this.interestRate = interestRate;
	}

	// Abstract method
	public abstract double calculateRepayment();

	// Common display method
	public void displayLoan() {
		System.out.println("Loan ID: " + loanId);
		System.out.println("Borrower Name: " + borrowerName);
		System.out.println("Principal Amount: " + principalAmount);
		System.out.println("Interest Rate: " + interestRate);
	}
}
