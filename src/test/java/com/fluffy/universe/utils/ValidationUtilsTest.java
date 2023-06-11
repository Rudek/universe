package com.fluffy.universe.utils;

import com.fluffy.universe.exceptions.HttpException;
import com.fluffy.universe.utils.ValidationUtils;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test ValidationUtils")
public class ValidationUtilsTest {

    @Test
    @DisplayName("Testing validation password")
    public void testIsValidPassword() {
        assertFalse(ValidationUtils.isValidPassword("aF01d_@"), "Password mustn't be shorter 8 symbols.");
        assertFalse(ValidationUtils.isValidPassword("aF01d_@flskjlskdldkjflsdllsdkfj"), "Password mustn't be longer 30.");
        assertFalse(ValidationUtils.isValidPassword("aF01af4f"), "Password must have non letter and non digital symbol.");
        assertFalse(ValidationUtils.isValidPassword("aFfjaf$f?"), "Password must have digital symbol.");
        assertFalse(ValidationUtils.isValidPassword("341513@?"), "Password must have digital symbol.");
        assertFalse(ValidationUtils.isValidPassword("abcffwer"), "Password must non letter and digital symbols.");
        assertFalse(ValidationUtils.isValidPassword("AGWRGJDF"), "Password must have small letters and digital symbols.");
        assertFalse(ValidationUtils.isValidPassword("23445369"), "Password must have letters and non digital and non letters symbols.");
        assertFalse(ValidationUtils.isValidPassword("aF01af4f"), "Password must have non letter and non digital symbol.");

        assertTrue(ValidationUtils.isValidPassword("fs$fFl24"), "Correct password.");
    }

    @Test
    @DisplayName("Testing validation email")
    public void testIsValidEmail() {
        assertFalse(ValidationUtils.isValidMail("@mail.ua"));
        assertFalse(ValidationUtils.isValidMail("test.mail.ua"));
        assertFalse(ValidationUtils.isValidMail("test@mail"));
        assertFalse(ValidationUtils.isValidMail("test@.ua"));

        assertTrue(ValidationUtils.isValidMail("test@mail.edu.ua"));
    }

    @Test
    @DisplayName("Testing validation date")
    public void testingIsValidDate() {
        assertFalse(ValidationUtils.isDateValid("20205-12-12"), "Incorrect year.");

        assertFalse(ValidationUtils.isDateValid("2020-22-12"), "Incorrect month 22.");
        assertFalse(ValidationUtils.isDateValid("2020-0-12"), "Incorrect month 0.");

        assertFalse(ValidationUtils.isDateValid("2020-01-0"), "Illegal 0 day on January.");
        assertFalse(ValidationUtils.isDateValid("2020-02-0"), "Illegal 0 day on February.");
        assertFalse(ValidationUtils.isDateValid("2020-03-0"), "Illegal 0 day on March.");
        assertFalse(ValidationUtils.isDateValid("2020-04-0"), "Illegal 0 day on April.");
        assertFalse(ValidationUtils.isDateValid("2020-05-0"), "Illegal 0 day on May.");
        assertFalse(ValidationUtils.isDateValid("2020-06-0"), "Illegal 0 day on June.");
        assertFalse(ValidationUtils.isDateValid("2020-07-0"), "Illegal 0 day on July.");
        assertFalse(ValidationUtils.isDateValid("2020-08-0"), "Illegal 0 day on August.");
        assertFalse(ValidationUtils.isDateValid("2020-09-0"), "Illegal 0 day on September.");
        assertFalse(ValidationUtils.isDateValid("2020-10-0"), "Illegal 0 day on October.");
        assertFalse(ValidationUtils.isDateValid("2020-11-0"), "Illegal 0 day on November.");
        assertFalse(ValidationUtils.isDateValid("2020-12-0"), "Illegal 0 day on December.");


        assertFalse(ValidationUtils.isDateValid("2019-01-32"), "Incorrect amount days on January.");
        assertFalse(ValidationUtils.isDateValid("2019-02-29"), "Incorrect amount days on February in non leap year.");
        assertFalse(ValidationUtils.isDateValid("1700-02-29"), "Incorrect amount days on February in non leap year.");

        assertFalse(ValidationUtils.isDateValid("2020-03-32"), "Incorrect amount days on March.");
        assertFalse(ValidationUtils.isDateValid("2020-04-31"), "Incorrect amount days on April.");
        assertFalse(ValidationUtils.isDateValid("2020-05-32"), "Incorrect amount days on May.");
        assertFalse(ValidationUtils.isDateValid("2020-06-31"), "Incorrect amount days on June.");
        assertFalse(ValidationUtils.isDateValid("2020-07-32"), "Incorrect amount days on July.");
        assertFalse(ValidationUtils.isDateValid("2020-08-32"), "Incorrect amount days on August.");
        assertFalse(ValidationUtils.isDateValid("2020-09-31"), "Incorrect amount days on September.");
        assertFalse(ValidationUtils.isDateValid("2020-10-32"), "Incorrect amount days on October.");
        assertFalse(ValidationUtils.isDateValid("2020-11-31"), "Incorrect amount days on November.");
        assertFalse(ValidationUtils.isDateValid("2020-12-32"), "Incorrect amount days on December.");

        assertTrue(ValidationUtils.isDateValid("2024-2-29"), "Correct days on February in leap year.");
        assertTrue(ValidationUtils.isDateValid("2020-2-29"), "Correct days on February in leap year.");
        assertTrue(ValidationUtils.isDateValid("2000-2-29"), "Correct days on February in leap year.");
        assertTrue(ValidationUtils.isDateValid("1600-2-29"), "Correct days on February in leap year.");
    }

    @Test
    @DisplayName("Testing validate parameter presence")
    void testIsValidParametersPresence() {
        assertThrows(HttpException.class, () -> {
            ValidationUtils.validateParametersPresence(new Object[]{null});
        });
    }
}
