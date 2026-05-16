package assignment9_10_11;

public class BankService {

    public double withdraw(double balance, double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        return balance - amount;
    }
}