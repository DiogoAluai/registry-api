package daluai.lib.registry_api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ApplicationTests {

	@Test
	public void checkSanity() {
		assertEquals(2 + 2, 4);
		assertNotEquals(10 + 9, 21);
	}
}
