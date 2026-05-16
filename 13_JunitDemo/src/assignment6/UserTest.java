package assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UserTest {

	// CHANGED: parameterized + grouped assertions
	@ParameterizedTest
	@CsvSource({ "Shivansh, 22, ACTIVE", "John, 30, INACTIVE" })
	void testUserPropertiesAll(String name, int age, String status) {
		User user = new User(name, age, status);

		assertAll("User Properties", () -> assertEquals(name, user.getName()), () -> assertEquals(age, user.getAge()),
				() -> assertEquals(status, user.getStatus()));
	}

	// CHANGED: old test disabled
	@Disabled
	@Test
	void testUserProperties() {
	}
}