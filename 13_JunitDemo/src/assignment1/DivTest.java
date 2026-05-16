package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DivTest {

	Calculator calc = new Calculator();

	// CHANGED: combined valid divide cases into parameterized test
	@ParameterizedTest
	@Order(1)
	@CsvSource({ "6, 3, 2", "-6, -3, 2", "6, -3, -2" })
	void testDivideAllCases(int a, int b, int expected) {
		assertEquals(expected, calc.divide(a, b));
	}

	// unchanged logic, kept separate
	@Test
	void testDivideNotEquals() {
		assertNotEquals(3, calc.divide(6, 3));
	}

	// unchanged (exception case)
	@Test
	void testDivideByZero() {
		assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
	}

	// CHANGED: old tests disabled
	@Disabled
	@Test
	void testDividePositive() {
		assertEquals(2, calc.divide(6, 3));
	}

	@Disabled
	@Test
	void testDivideNegative() {
		assertEquals(2, calc.divide(-6, -3));
	}

	@Disabled
	@Test
	void testDivideMixed() {
		assertEquals(-2, calc.divide(6, -3));
	}
}