package assignment9_10_11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarksValidatorTest {

	MarksValidator validator = new MarksValidator();

	// CHANGED: combined all boundary cases
	@ParameterizedTest
	@CsvSource({ "0, true", "1, true", "99, true", "100, true", "-1, false", "101, false" })
	void testMarksAllCases(int marks, boolean expected) {
		assertEquals(expected, validator.isValidMarks(marks));
	}

	// CHANGED: old tests disabled
	@Disabled
	void testZero() {
	}

	@Disabled
	void testOne() {
	}

	@Disabled
	void testNinetyNine() {
	}

	@Disabled
	void testHundred() {
	}

	@Disabled
	void testBelowZero() {
	}

	@Disabled
	void testAboveHundred() {
	}
}