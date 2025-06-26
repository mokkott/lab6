package org.example;

public class PasswordValidator {
    public static boolean isStrongPassword(String password) {
        if (password == null || password.length() < 10) return false;

        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasLower = false;

        for (char ch : password.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false; // недопустимый символ
            }

            if (Character.isDigit(ch)) hasDigit = true;
            else if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
        }

        return hasDigit && hasUpper && hasLower;
    }
}
