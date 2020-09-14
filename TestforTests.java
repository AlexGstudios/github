package school;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class TestforTests {
	
	// annotation are the @xxx before the method
	// it declares what you want to do with the following method
	// @Test test if the method works
	
	String name = "Olof";
	
	@Test
	void string() {
		System.out.println(" adding test");
		stringOfThings sot = new stringOfThings();
		assertEquals("Aolof", sot.addA("olof"));
	}
	@Test
	void stringTwo() {
		System.out.println(" adding test");
		// assertions is a collection static utility methods, as below "assertTrue" etc
		// it supports asserting conditions in tests
		// unless noted a failed assertion throws an AssertionFailedError or a subclass thereof.
		assertTrue(name.startsWith("O"));
	}
}
