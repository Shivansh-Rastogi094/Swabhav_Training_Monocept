package assignment5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BankAccountTest {

	BankAccount acc;

	@BeforeEach
	void setUp() {
		acc = new BankAccount();
		acc.deposit(1000);
	}

	@AfterEach
	void tearDown() {
		acc = null;
	}

	// CHANGED: grouped valid operations
	@Test
	void testValidOperationsAll() {
		long depositBalance = acc.deposit(500);
		long withdrawBalance = acc.withdraw(300);

		assertAll("Valid Operations", () -> assertEquals(1500, depositBalance),
				() -> assertEquals(1200, withdrawBalance), () -> assertEquals(1200, acc.getBalance()));
	}

	// CHANGED: combined invalid deposit cases
	@ParameterizedTest
	@ValueSource(ints = { 0, -100 })
	void testInvalidDeposit(int amount) {
		assertThrows(IllegalArgumentException.class, () -> acc.deposit(amount));
	}

	// CHANGED: combined invalid withdraw cases
	@ParameterizedTest
	@ValueSource(ints = { 0, -1100, 1100 })
	void testInvalidWithdraw(int amount) {
		assertThrows(IllegalArgumentException.class, () -> acc.withdraw(amount));
	}

	// unchanged logic
	@Test
	void testBalanceAfterMultipleOperations() {
		acc.deposit(500);
		acc.withdraw(200);
		acc.withdraw(300);

		assertEquals(1000, acc.getBalance());
	}

	// unchanged logic
	@Test
	void testBalanceUnchangedAfterFailedTransaction() {
		try {
			acc.withdraw(2000);
		} catch (Exception e) {
		}

		assertEquals(1000, acc.getBalance());
	}

	// CHANGED: old tests disabled
	@Disabled
	@Test
	void testValidDeposit() {
	}

	@Disabled
	@Test
	void testValidWithdraw() {
	}

	@Disabled
	@Test
	void testDepositNegativeAmount() {
	}

	@Disabled
	@Test
	void testDepositZero() {
	}

	@Disabled
	@Test
	void testWithdrawMoreThanbalance() {
	}

	@Disabled
	@Test
	void testWithdrawZero() {
	}

	@Disabled
	@Test
	void testWithdrawNegativeAmount() {
	}
}