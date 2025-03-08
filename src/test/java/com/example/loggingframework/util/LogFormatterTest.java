package com.example.loggingframework.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The {@code LogFormatterTest} class contains unit tests for the {@link LogFormatter} class.
 * It ensures that the {@link LogFormatter#formatLogMessage(String, String)} method behaves as expected
 * under various conditions, including valid and invalid inputs.
 *
 * <p>This class tests the following scenarios:
 * <ul>
 *     <li>Formatting a log message with valid input.</li>
 *     <li>Formatting a log message with the log level in uppercase.</li>
 *     <li>Handling null log levels.</li>
 *     <li>Handling null log messages.</li>
 *     <li>Handling both null log levels and messages.</li>
 * </ul>
 *
 * @author Your Name
 * @version 1.0
 * @see LogFormatter
 */
public class LogFormatterTest {

    /**
     * Tests the {@link LogFormatter#formatLogMessage(String, String)} method with valid input.
     * Verifies that the log message is formatted correctly with the log level in lowercase.
     */
    @Test
    public void testFormatLogMessage_ValidInput() {
        // Arrange
        String level = "info";
        String message = "This is a log message.";
        String expectedOutput = "[INFO] This is a log message.";

        // Act
        String formattedMessage = LogFormatter.formatLogMessage(level, message);

        // Assert
        assertEquals(expectedOutput, formattedMessage, "Formatted message should match the expected output");
    }

    /**
     * Tests the {@link LogFormatter#formatLogMessage(String, String)} method with the log level in uppercase.
     * Verifies that the log message is formatted correctly and the log level is converted to uppercase.
     */
    @Test
    public void testFormatLogMessage_LevelInUpperCase() {
        // Arrange
        String level = "ERROR";
        String message = "An error occurred!";
        String expectedOutput = "[ERROR] An error occurred!";

        // Act
        String formattedMessage = LogFormatter.formatLogMessage(level, message);

        // Assert
        assertEquals(expectedOutput, formattedMessage, "Formatted message should match the expected output");
    }

    /**
     * Tests the {@link LogFormatter#formatLogMessage(String, String)} method with a null log level.
     * Verifies that an {@link IllegalArgumentException} is thrown with the appropriate error message.
     */
    @Test
    public void testFormatLogMessage_NullLevel() {
        // Arrange
        String level = null;
        String message = "This is a log message.";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LogFormatter.formatLogMessage(level, message);
        }, "IllegalArgumentException should be thrown for null level");

        assertEquals("Level and message must not be null", exception.getMessage(), "Exception message should match");
    }

    /**
     * Tests the {@link LogFormatter#formatLogMessage(String, String)} method with a null log message.
     * Verifies that an {@link IllegalArgumentException} is thrown with the appropriate error message.
     */
    @Test
    public void testFormatLogMessage_NullMessage() {
        // Arrange
        String level = "debug";
        String message = null;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LogFormatter.formatLogMessage(level, message);
        }, "IllegalArgumentException should be thrown for null message");

        assertEquals("Level and message must not be null", exception.getMessage(), "Exception message should match");
    }

    /**
     * Tests the {@link LogFormatter#formatLogMessage(String, String)} method with both null log level and message.
     * Verifies that an {@link IllegalArgumentException} is thrown with the appropriate error message.
     */
    @Test
    public void testFormatLogMessage_NullLevelAndMessage() {
        // Arrange
        String level = null;
        String message = null;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LogFormatter.formatLogMessage(level, message);
        }, "IllegalArgumentException should be thrown for null level and message");

        assertEquals("Level and message must not be null", exception.getMessage(), "Exception message should match");
    }
}