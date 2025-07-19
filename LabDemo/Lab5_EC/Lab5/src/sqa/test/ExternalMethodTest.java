package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import sqa.main.Strings;

class ExternalMethodTest {

	 @ParameterizedTest
	 @MethodSource("test.StringParameters#provideSomeStrings")
	    void testWithExternalMethodSource(String input) {
		 	assertTrue(Strings.isBlank(input));
	 }
}

class StringParameters{
	static Stream<String> provideSomeStrings() {
        return Stream.of(".", "oo", "OOO", null, "", "  ");
	}
}