package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AddTest {

    Calculator calc = new Calculator();

    // CHANGED: combined all cases into parameterized test
    @ParameterizedTest
    @Order(1)
    @CsvSource({
        "2, 3, 5",
        "-2, -3, -5",
        "3, -2, 1",
        "3, 0, 3"
    })
    void testAddAllCases(int a, int b, int expected) {
        assertEquals(expected, calc.add(a, b));
    }

    // unchanged logic, kept separate
    @Test
    void testAddNotEquals() {
        assertNotEquals(6, calc.add(2, 3));
    }

    // CHANGED: old tests disabled
    @Disabled
    @Test
    void testAddPositive() {
        assertEquals(5, calc.add(2, 3));
    }

    @Disabled
    @Test
    void testAddNegative() {
        assertEquals(-5, calc.add(-2, -3));
    }

    @Disabled
    @Test
    void testAddMixed() {
        assertEquals(1, calc.add(3, -2));
    }

    @Disabled
    @Test
    void testAddZero() {
        assertEquals(3, calc.add(3, 0));
    }
}