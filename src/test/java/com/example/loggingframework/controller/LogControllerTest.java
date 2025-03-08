package com.example.loggingframework.controller;

import com.example.loggingframework.service.LogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LogControllerTest {

    @Mock
    private LogService logService; // Mock the LogService

    @InjectMocks
    private LogController logController; // Inject the mock LogService into LogController

    @BeforeEach
    public void setUp() {
        // Set up the request context for testing
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void testProcessInput_ValidInput() {
        // Arrange
        String input = "test input";
        String expectedOutput = "Processed: " + input;

        // Mock the LogService behavior
        when(logService.performAction(input)).thenReturn(expectedOutput);

        // Act
        String result = logController.processInput(input);

        // Assert
        assertEquals(expectedOutput, result, "Response should match the processed input");

        // Verify that the LogService was called with the expected input
        verify(logService).performAction(input);
    }

    @Test
    public void testProcessInput_NullInput() {
        // Arrange
        String input = null;

        // Mock the LogService behavior to throw an exception
        when(logService.performAction(input)).thenThrow(new IllegalArgumentException("Input cannot be null"));

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            logController.processInput(input);
        }, "IllegalArgumentException should be thrown for null input");

        assertEquals("Input cannot be null", exception.getMessage(), "Exception message should match");

        // Verify that the LogService was called with the expected input
        verify(logService).performAction(input);
    }
}