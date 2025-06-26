package org.example;

public class DigitSumCalculator {
    public static int sumOfDigits(String text) {
        int sum = 0;
        for (char ch : text.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += ch - '0';
            }
        }
        return sum;
    }
}
