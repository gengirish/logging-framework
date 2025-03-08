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

/**
 * The {@code LogControllerTest} class contains unit tests for the {@link LogController} class.
 * It ensures that the {@link LogController#processInput(String)} method behaves as expected
 * under various conditions, including valid and invalid inputs.
 *
 * <p>This class uses Mockito to mock dependencies and Spring's request context for testing.
 * It tests the following scenarios:
 * <ul>
 *     <li>Processing valid input and verifying the response.</li>
 *     <li>Handling null input and verifying the exception thrown.</li>
 * </ul>
 *
 * @author Your Name
 * @version 1.0
 * @see LogController
 * @see LogService
 */
@ExtendWith(MockitoExtension.class)
public class LogControllerTest {

    @Mock
    private LogService logService; // Mock the LogService

    @InjectMocks
    private LogController logController; // Inject the mock LogService into LogController

    /**
     * Sets up the test environment before each test case.
     * Initializes the request context for testing.
     */
    @BeforeEach
    public void setUp() {
        // Set up the request context for testing
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    /**
     * Tests the {@link LogController#processInput(String)} method with valid input.
     * Verifies that the method processes the input correctly and returns the expected output.
     * Also ensures that the {@link LogService#performAction(String)} method is called with the correct input.
     */
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

    /**
     * Tests the {@link LogController#processInput(String)} method with null input.
     * Verifies that an {@link IllegalArgumentException} is thrown with the appropriate error message.
     * Also ensures that the {@link LogService#performAction(String)} method is called with the correct input.
     */
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