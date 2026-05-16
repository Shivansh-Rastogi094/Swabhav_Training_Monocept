package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MulTest {

	Calculator calc = new Calculator();

	// CHANGED: combined all multiply cases into parameterized test
	@ParameterizedTest
	@Order(1)
	@CsvSource({ "2, 3, 6", "-2, -3, 6", "2, -3, -6", "5, 0, 0" })
	void testMultiplyAllCases(int a, int b, int expected) {
		assertEquals(expected, calc.multiply(a, b));
	}

	// unchanged logic, kept separate
	@Test
	void testMultiplyNotEquals() {
		assertNotEquals(5, calc.multiply(2, 3));
	}

	// CHANGED: old tests disabled
	@Disabled
	@Test
	void testMultiplyPositive() {
		assertEquals(6, calc.multiply(2, 3));
	}

	@Disabled
	@Test
	void testMultiplyNegative() {
		assertEquals(6, calc.multiply(-2, -3));
	}

	@Disabled
	@Test
	void testMultiplyMixed() {
		assertEquals(-6, calc.multiply(2, -3));
	}

	@Disabled
	@Test
	void testMultiplyZero() {
		assertEquals(0, calc.multiply(5, 0));
	}
}