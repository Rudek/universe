package com.fluffy.universe;

import com.fluffy.universe.utils.ValidationUtils;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test ValidationUtils")
public class ValidationUtilsTest {

    @Test
    @DisplayName("Testing validation password")
    public void testIsValidPassword() {
        assertFalse(ValidationUtils.isValidPassword("aF01d_@"), "Password too short, and it return false.");
        assertFalse(ValidationUtils.isValidPassword("aF01d_@flskjlskdldkjflsdllsdkfj"), "Password too long, and it return false");
    }

}
