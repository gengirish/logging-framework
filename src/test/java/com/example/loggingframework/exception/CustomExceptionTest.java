package com.example.loggingframework.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link CustomException} class.
 * This class tests the behavior of the custom exception.
 */
class CustomExceptionTest {

    /**
     * Tests that the {@link CustomException} is thrown with the correct message.
     */
    @Test
    void testCustomExceptionMessage() {
        String errorMessage = "Test error message";
        CustomException exception = new CustomException(errorMessage);

        // Assert that the exception message is correct
        assertEquals(errorMessage, exception.getMessage());
    }

    /**
     * Tests that the {@link CustomException} is thrown and can be caught.
     */
    @Test
    void testCustomExceptionThrown() {
        String errorMessage = "Test error message";

        // Assert that the exception is thrown
        Exception exception = assertThrows(CustomException.class, () -> {
            throw new CustomException(errorMessage);
        });

        // Assert that the exception message is correct
        assertEquals(errorMessage, exception.getMessage());
    }
}
