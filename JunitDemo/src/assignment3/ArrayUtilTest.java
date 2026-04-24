package assignment3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayUtilTest {

	ArrayUtil util = new ArrayUtil();

	// CHANGED: combined array cases using MethodSource
	@ParameterizedTest
	@Order(1)
	@MethodSource("arrayProvider")
	void testReverseAllCases(int[] input, int[] expected) {
		assertArrayEquals(expected, util.reverseArray(input));
	}

	static Stream<org.junit.jupiter.params.provider.Arguments> arrayProvider() {
		return Stream.of(
				org.junit.jupiter.params.provider.Arguments.of(new int[] { 1, 2, 3, 4 }, new int[] { 4, 3, 2, 1 }),
				org.junit.jupiter.params.provider.Arguments.of(new int[] { 5 }, new int[] { 5 }),
				org.junit.jupiter.params.provider.Arguments.of(new int[] {}, new int[] {}));
	}

	// unchanged (null handled separately)
	@Test
	@Tag("NULLARRAY")
	void testReverseNullArray() {
		assertNull(util.reverseArray(null));
	}

	// CHANGED: old tests disabled
	@Disabled
	@Test
	@Tag("NORMALARRAY")
	void testReverseNormalArray() {
	}

	@Disabled
	@Test
	@Tag("SINGLEELEMENT")
	void testReverseSingleElement() {
	}

	@Disabled
	@Test
	@Tag("EMPTYARRAY")
	void testReverseEmptyArray() {
	}
}