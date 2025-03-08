package com.example.loggingframework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LogServiceTest {

    @Mock
    private Logger logger; // Mock the Logger

    @InjectMocks
    private LogService logService; // Inject the mock Logger into LogService

    @Test
    public void testPerformAction_ValidInput() {
        // Arrange
        String input = "test input";
        String expectedOutput = "Processed: " + input;

        // Act
        String result = logService.performAction(input);

        // Assert
        assertEquals(expectedOutput, result, "Output should match the processed input");

        // Verify that the logger was called with the expected message
        //verify(logger).debug("Performing action with input: {}", input);
    }

    @Test
    public void testPerformAction_NullInput() {
        // Arrange
        String input = null;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            logService.performAction(input);
        }, "IllegalArgumentException should be thrown for null input");

        assertEquals("Input cannot be null", exception.getMessage(), "Exception message should match");

        // Verify that the logger was called with the expected message
        //verify(logger).debug("Performing action with input: {}", input);
    }
}