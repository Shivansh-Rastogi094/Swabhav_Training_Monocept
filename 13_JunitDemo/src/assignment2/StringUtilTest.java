package assignment2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringUtilTest {

	StringUtil util = new StringUtil();

	// CHANGED: combined isEmpty tests
	@ParameterizedTest
	@Order(1)
	@CsvSource({ "'', true", "' ', false", "hello, false" })
	void testIsEmptyAllCases(String input, boolean expected) {
		assertEquals(expected, util.isEmpty(input));
	}

	@Test
	void testIsEmptyNull() {
		assertTrue(util.isEmpty(null));
	}

	// CHANGED: combined toUpperCase tests
	@ParameterizedTest
	@Order(2)
	@CsvSource({ "'', ''", "' ', ' '", "hello, HELLO" })
	void testToUpperCaseAllCases(String input, String expected) {
		assertEquals(expected, util.toUpperCase(input));
	}

	@Test
	void testToUpperCaseNull() {
		assertNull(util.toUpperCase(null));
	}

	// CHANGED: combined getLength tests
	@ParameterizedTest
	@Order(3)
	@CsvSource({ "'', 0", "' ', 1", "hello, 5" })
	void testGetLengthAllCases(String input, int expected) {
		assertEquals(expected, util.getLength(input));
	}

	@Test
	void testGetLengthNull() {
		assertNull(util.getLength(null));
	}

	// CHANGED: old tests disabled
	@Disabled
	@Test
	void testIsEmptyWithNull() {
	}

	@Disabled
	@Test
	void testIsEmptyWithEmptyString() {
	}

	@Disabled
	@Test
	void testIsEmptyWithWhitespace() {
	}

	@Disabled
	@Test
	void testIsEmptyWithNormalString() {
	}

	@Disabled
	@Test
	void testToUpperCaseNullOld() {
	}

	@Disabled
	@Test
	void testToUpperCaseEmpty() {
	}

	@Disabled
	@Test
	void testToUpperCaseWhitespace() {
	}

	@Disabled
	@Test
	void testToUpperCaseNormal() {
	}

	@Disabled
	@Test
	void testGetLengthNullOld() {
	}

	@Disabled
	@Test
	void testGetLengthEmpty() {
	}

	@Disabled
	@Test
	void testGetLengthWhitespace() {
	}

	@Disabled
	@Test
	void testGetLengthNormal() {
	}
}