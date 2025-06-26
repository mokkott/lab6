package org.example;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DigitSumCalculatorTest {

    @Test
    public void testEmptyString() {
        assertEquals(0, DigitSumCalculator.sumOfDigits(""));
    }

    @Test
    public void testNoDigits() {
        assertEquals(0, DigitSumCalculator.sumOfDigits("No digits here!"));
    }

    @Test
    public void testOnlyDigits() {
        assertEquals(15, DigitSumCalculator.sumOfDigits("12345"));
    }

    @Test
    public void testMixedText() {
        assertEquals(6, DigitSumCalculator.sumOfDigits("abc1d2e3f"));
    }

    @Test
    public void testRussianExample() {
        String example = "Today is June 26, 2025, temperature +23.5°C.";
        int expectedSum = 2 + 6 + 2 + 0 + 2 + 5 + 2 + 3 + 5; // 27
        int result = DigitSumCalculator.sumOfDigits(example);
        System.out.println("Sum of all digits: " + result);
        assertEquals(expectedSum, result);
    }
}