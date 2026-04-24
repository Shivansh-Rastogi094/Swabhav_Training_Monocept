package assignment5;

public class BankAccount  {
long balance=0;
	public long deposit(int amount) {
		if(amount <=0) throw  new IllegalArgumentException("Amount must be Positive");
		balance+=amount;
		return balance;
	};
	
	public long withdraw(int amount) {
		if(amount <=0) throw new IllegalArgumentException("Amount must be Positive");
		if(amount > balance) throw new IllegalArgumentException("Insufficent Balance");
		balance-=amount;
		return balance;
	};
	
	public long getBalance() {
		return balance;
	};
}
