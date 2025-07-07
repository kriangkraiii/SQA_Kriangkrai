package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleUnitTest {

	int results = 4;
	
	@Test
	void test_demo_pass_unittest() {
		assertEquals(4, results);
	}
	
	@Test
	void test_demo_fail_unittest() {
		assertEquals(4, 2*1);
	}
}
