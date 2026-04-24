package assignment7_8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Test8 {

    Calculator calc = new Calculator();

    @Test
    void shouldThrowArithmeticExceptionWhenDividingByZero() {

        ArithmeticException exception = assertThrows(
            ArithmeticException.class,
            () -> calc.divide(10, 0)
        );

        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void shouldReturnCorrectResultWhenDivisionIsValid() {
        assertEquals(5, calc.divide(10, 2));
    }
}