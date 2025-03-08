package com.example.loggingframework.mode;


import com.example.loggingframework.model.LogMessage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogMessageTest {

    @Test
    public void testDefaultConstructor() {
        // Arrange
        LogMessage logMessage = new LogMessage();

        // Assert
        assertNull(logMessage.getLevel(), "Default level should be null");
        assertNull(logMessage.getMessage(), "Default message should be null");
    }

    @Test
    public void testParameterizedConstructor() {
        // Arrange
        String level = "INFO";
        String message = "This is a log message.";

        // Act
        LogMessage logMessage = new LogMessage(level, message);

        // Assert
        assertEquals(level, logMessage.getLevel(), "Level should match the constructor argument");
        assertEquals(message, logMessage.getMessage(), "Message should match the constructor argument");
    }

    @Test
    public void testSettersAndGetters() {
        // Arrange
        LogMessage logMessage = new LogMessage();
        String level = "ERROR";
        String message = "An error occurred!";

        // Act
        logMessage.setLevel(level);
        logMessage.setMessage(message);

        // Assert
        assertEquals(level, logMessage.getLevel(), "Level should match the set value");
        assertEquals(message, logMessage.getMessage(), "Message should match the set value");
    }

    @Test
    public void testSetLevel() {
        // Arrange
        LogMessage logMessage = new LogMessage();
        String level = "DEBUG";

        // Act
        logMessage.setLevel(level);

        // Assert
        assertEquals(level, logMessage.getLevel(), "Level should be updated to the new value");
    }

    @Test
    public void testSetMessage() {
        // Arrange
        LogMessage logMessage = new LogMessage();
        String message = "This is a debug message.";

        // Act
        logMessage.setMessage(message);

        // Assert
        assertEquals(message, logMessage.getMessage(), "Message should be updated to the new value");
    }
}
