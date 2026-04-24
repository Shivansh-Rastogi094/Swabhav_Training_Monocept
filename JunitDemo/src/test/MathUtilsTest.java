package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import demo.MathUtils;

public class MathUtilsTest {
//	 @Test
	 @DisplayName("Test 1")
	 @RepeatedTest(5)
	 @Tag("Important")
	    void testAdd() {
	        int result = MathUtils.add(2, 3);
	        assertEquals(5, result);
	    }
}
