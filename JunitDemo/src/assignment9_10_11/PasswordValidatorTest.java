package assignment9_10_11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PasswordValidatorTest {

	PasswordValidator validator = new PasswordValidator();

	// CHANGED: combined all non-null cases
	@ParameterizedTest
	@CsvSource({ "Password1, true", "password1, false", "Password, false", "Pass1, false", "'', false" })
	void testPasswordAllCases(String input, boolean expected) {
		assertEquals(expected, validator.isValid(input));
	}

	// unchanged (null handled separately)
	@Test
	void testNullPassword() {
		assertFalse(validator.isValid(null));
	}

	// CHANGED: old tests disabled
	@Disabled
	@Test
	void testValidPassword() {
	}

	@Disabled
	@Test
	void testNoUppercase() {
	}

	@Disabled
	@Test
	void testNoNumber() {
	}

	@Disabled
	@Test
	void testShortLength() {
	}

	@Disabled
	@Test
	void testEmptyPassword() {
	}
}