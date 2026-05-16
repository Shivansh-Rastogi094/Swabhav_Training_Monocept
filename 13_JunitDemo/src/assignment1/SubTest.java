package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SubTest {

	Calculator calc = new Calculator();

	// CHANGED: combined all subtract cases into parameterized test
	@ParameterizedTest
	@Order(1)
	@CsvSource({ "3, 2, 1", "-2, -3, 1", "0, 3, -3", "5, 5, 0" })
	void testSubtractAllCases(int a, int b, int expected) {
		assertEquals(expected, calc.subtract(a, b));
	}

	// unchanged logic, kept separate
	@Test
	void testSubtractNotEquals() {
		assertNotEquals(5, calc.subtract(3, 2));
	}

	// CHANGED: old tests disabled
	@Disabled
	@Test
	void testSubtractPositive() {
		assertEquals(1, calc.subtract(3, 2));
	}

	@Disabled
	@Test
	void testSubtractNegative() {
		assertEquals(1, calc.subtract(-2, -3));
	}

	@Disabled
	@Test
	void testSubtractZero() {
		assertEquals(-3, calc.subtract(0, 3));
	}

	@Disabled
	@Test
	void testSubtractResultZero() {
		assertEquals(0, calc.subtract(5, 5));
	}
}