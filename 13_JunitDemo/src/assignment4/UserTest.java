package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class UserTest {

	User user;

	@BeforeEach
	void setUp() {
		user = new User("Shivansh", 22);
	}

	@AfterEach
	void tearDown() {
		user = null;
	}

	// CHANGED: combined valid user checks using assertAll
	@Test
	void testValidUserAllProperties() {
		assertAll("User Properties", () -> assertNotNull(user), () -> assertEquals("Shivansh", user.getName()),
				() -> assertEquals(22, user.getAge()));
	}

	// unchanged (exception case)
	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, () -> new User(null, 22));
	}

	// unchanged (exception case)
	@Test
	void testNegativeAge() {
		assertThrows(IllegalArgumentException.class, () -> new User("John", -5));
	}

	// CHANGED: old test disabled
	@Disabled
	@Test
	void testValidUser() {
	}
}