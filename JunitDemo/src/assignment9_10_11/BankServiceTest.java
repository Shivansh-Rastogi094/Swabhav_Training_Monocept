package assignment9_10_11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BankServiceTest {

	BankService service = new BankService();

	// CHANGED: combined valid case
	@ParameterizedTest
	@CsvSource({ "1000, 500, 500" })
	void testValidWithdrawAll(double balance, double amount, double expected) {
		assertEquals(expected, service.withdraw(balance, amount));
	}

	// CHANGED: combined invalid cases
	@ParameterizedTest
	@CsvSource({ "500, 1000", "500, 0", "500, -100" })
	void testInvalidWithdrawAll(double balance, double amount) {
		assertThrows(IllegalArgumentException.class, () -> service.withdraw(balance, amount));
	}

	// CHANGED: old tests disabled
	@Disabled
	@Test
	void testValidWithdraw() {
	}

	@Disabled
	@Test
	void testAmountGreaterThanBalance() {
	}

	@Disabled
	@Test
	void testZeroAmount() {
	}

	@Disabled
	@Test
	void testNegativeAmount() {
	}
}