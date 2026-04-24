package assignment7_8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Test7 {

    Calculator calc = new Calculator();

    @Test
    void shouldReturnSumWhenBothNumbersArePositive() {
        assertEquals(10, calc.add(5, 5));
    }

    @Test
    void shouldReturnZeroWhenBothNumbersAreZero() {
        assertEquals(0, calc.add(0, 0));
    }

    @Test
    void shouldReturnNegativeResultWhenOneNumberIsNegative() {
        assertEquals(-5, calc.add(-10, 5));
    }

    @Test
    void shouldReturnCorrectDifferenceWhenNumbersAreValid() {
        assertEquals(2, calc.subtract(5, 3));
    }
}