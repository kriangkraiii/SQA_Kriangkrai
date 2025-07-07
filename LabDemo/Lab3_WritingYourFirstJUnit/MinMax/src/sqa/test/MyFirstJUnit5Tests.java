package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyFirstJUnit5Tests {

	@Test
	void myFirstTest() {
		assertEquals(4, 2+2);
	}

}
