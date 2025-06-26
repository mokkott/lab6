package org.example;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordValidatorTest {
    @Test
    public void testValidPasswords() {
        assertTrue(PasswordValidator.isStrongPassword("StrongPass1"));
        assertTrue(PasswordValidator.isStrongPassword("Aa1bbccdde_"));
    }

    @Test
    public void testTooShort() {
        assertFalse(PasswordValidator.isStrongPassword("Aa1short"));
    }

    @Test
    public void testMissingDigit() {
        assertFalse(PasswordValidator.isStrongPassword("NoDigitsHereA"));
    }

    @Test
    public void testMissingUpperCase() {
        assertFalse(PasswordValidator.isStrongPassword("lowercase123"));
    }

    @Test
    public void testMissingLowerCase() {
        assertFalse(PasswordValidator.isStrongPassword("UPPERCASE123"));
    }

    @Test
    public void testInvalidCharacter() {
        assertFalse(PasswordValidator.isStrongPassword("Valid12345!")); // '!' запрещён
    }

    @Test
    public void testNullAndEmpty() {
        assertFalse(PasswordValidator.isStrongPassword(null));
        assertFalse(PasswordValidator.isStrongPassword(""));
    }
}
