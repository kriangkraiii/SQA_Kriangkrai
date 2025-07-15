import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RomanNumeralsTest {

    RomanNumerals romanNumerals = new RomanNumerals();

    // 1) Single digit
    @Test
    void testSingleDigit() {
        assertEquals(1, romanNumerals.convertRomanNumToInt("I"));
        assertEquals(5, romanNumerals.convertRomanNumToInt("V"));
    }

    // 2) Two digits – first < second
    @Test
    void testTwoDigitsFirstSmaller() {
        assertEquals(4, romanNumerals.convertRomanNumToInt("IV"));
        assertEquals(9, romanNumerals.convertRomanNumToInt("IX"));
    }

    // 3) Two digits – first > second
    @Test
    void testTwoDigitsFirstLarger() {
        assertEquals(6, romanNumerals.convertRomanNumToInt("VI"));
        assertEquals(101, romanNumerals.convertRomanNumToInt("CI"));
    }

    // 4) Two digits – same number
    @Test
    void testTwoDigitsSameNumber() {
        assertEquals(2, romanNumerals.convertRomanNumToInt("II"));
        assertEquals(20, romanNumerals.convertRomanNumToInt("XX"));
    }

    // 5) Multiple digits – same number
    @Test
    void testMultipleDigitsSameNumber() {
        assertEquals(3, romanNumerals.convertRomanNumToInt("III"));
        assertEquals(30, romanNumerals.convertRomanNumToInt("XXX"));
    }

    // 6) Multiple digits – first digit is larger than the rest
    @Test
    void testMultipleDigitsFirstLarger() {
        assertEquals(26, romanNumerals.convertRomanNumToInt("XXVI"));
        assertEquals(27, romanNumerals.convertRomanNumToInt("XXVII"));
        assertEquals(67, romanNumerals.convertRomanNumToInt("LXVII"));
    }

    // 7) Multiple digits – first digit is largest, rest is combination
    @Test
    void testMultipleDigitsFirstLargestCombination() {
        assertEquals(74, romanNumerals.convertRomanNumToInt("LXXIV"));
        assertEquals(76, romanNumerals.convertRomanNumToInt("LXXVI"));
        assertEquals(78, romanNumerals.convertRomanNumToInt("LXXVIII"));
        assertEquals(84, romanNumerals.convertRomanNumToInt("LXXXIV"));
    }

    // Negative Test Scenarios
    @Test
    void testNotRomanNumeral() {
        assertThrows(NullPointerException.class, () -> romanNumerals.convertRomanNumToInt("J"));
        assertThrows(NullPointerException.class, () -> romanNumerals.convertRomanNumToInt("K"));
    }

    @Test
    void testWrongRepeatingDigits() {
        assertThrows(NullPointerException.class, () -> romanNumerals.convertRomanNumToInt("VV"));
        assertThrows(NullPointerException.class, () -> romanNumerals.convertRomanNumToInt("LL"));
    }

    @Test
    void testMoreThanThreeRepeatingDigits() {
        assertThrows(NullPointerException.class, () -> romanNumerals.convertRomanNumToInt("XXXX"));
        assertThrows(NullPointerException.class, () -> romanNumerals.convertRomanNumToInt("IIII"));
    }
}
