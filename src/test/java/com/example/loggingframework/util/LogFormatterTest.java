package com.example.loggingframework.util;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogFormatterTest {

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
