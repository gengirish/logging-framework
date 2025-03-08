package com.example.loggingframework.aspect;

import static org.mockito.Mockito.*;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.Arrays;

/**
 * Test class for {@link LoggingAspect}.
 * This class contains unit tests to ensure the correct behavior of the logging aspect.
 */
class LoggingAspectTest {

    private LoggingAspect loggingAspect;
    private Logger mockLogger;
    private JoinPoint mockJoinPoint;
    private Signature mockSignature;

    /**
     * Setup method to initialize the test environment before each test.
     * This method mocks the Logger, JoinPoint, and Signature objects.
     */
    @BeforeEach
    void setUp() {
        loggingAspect = new LoggingAspect();
        // Mock LoggerFactory to intercept logger calls.
        mockLogger = mock(Logger.class);
        // Use reflection to inject the mock logger into the LoggingAspect instance.
        try {
            var loggerField = LoggingAspect.class.getDeclaredField("logger");
            loggerField.setAccessible(true);
            loggerField.set(loggingAspect, mockLogger);
        } catch (Exception e) {
            throw new RuntimeException("Failed to inject mock logger", e);
        }

        // Mock JoinPoint and Signature
        mockJoinPoint = mock(JoinPoint.class);
        mockSignature = mock(Signature.class);
        when(mockJoinPoint.getSignature()).thenReturn(mockSignature);
        when(mockSignature.getName()).thenReturn("testMethod"); // Ensure getName() returns the method name
    }

    /**
     * Test the {@link LoggingAspect#logBefore(JoinPoint)} method.
     * This test ensures that the log entry is recorded correctly.
     */
    @Test
    void testLogBefore() {
        // Setup: Mock JoinPoint and Signature
        when(mockJoinPoint.getArgs()).thenReturn(new Object[]{"arg1", 2}); // Mock arguments

        // Call the method to test
        loggingAspect.logBefore(mockJoinPoint);

        // Verify: Ensure the logger's info method was called with correct message and arguments
        verify(mockLogger).info("Entering method: {} with arguments: {}", "testMethod", new Object[]{"arg1", 2});
    }

    /**
     * Test the {@link LoggingAspect#logAfterReturning(JoinPoint, Object)} method.
     * This test ensures that the log exit is recorded correctly.
     */
    @Test
    void testLogAfterReturning() {
        // Setup: Mock JoinPoint and Signature
        Object result = "testResult";

        // Call the method to test
        loggingAspect.logAfterReturning(mockJoinPoint, result);

        // Verify: Ensure the logger's info method was called with correct message and arguments
        verify(mockLogger).info("Exiting method: {} with result: {}", "testMethod", "testResult");
    }

    /**
     * Test the {@link LoggingAspect#logAfterThrowing(JoinPoint, Throwable)} method.
     * This test ensures that exceptions are logged correctly.
     */
    @Test
    void testLogAfterThrowing() {
        // Setup: Mock JoinPoint and Signature
        Throwable error = new RuntimeException("testException");

        // Call the method to test
        loggingAspect.logAfterThrowing(mockJoinPoint, error);

        // Verify: Ensure the logger's error method was called with correct message and arguments
        verify(mockLogger).error("Exception in method: {} with cause: {}", "testMethod", "testException");
    }

    /**
     * Test the {@link LoggingAspect#logAfterThrowing(JoinPoint, Throwable)} method with a null cause.
     * This test ensures that exceptions with null causes are logged correctly.
     */
    @Test
    void testLogAfterThrowingWithNullCause() {
        // Setup: Mock JoinPoint and Signature
        Throwable error = new RuntimeException();

        // Call the method to test
        loggingAspect.logAfterThrowing(mockJoinPoint, error);

        // Verify: Ensure the logger's error method was called with correct message and arguments
        verify(mockLogger).error("Exception in method: {} with cause: {}", "testMethod", null);
    }

    /**
     * Test the {@link LoggingAspect#logAfterReturning(JoinPoint, Object)} method with a null result.
     * This test ensures that methods returning null are logged correctly.
     */
    @Test
    void testLogAfterReturningWithNullResult() {
        // Setup: Mock JoinPoint and Signature

        // Call the method to test
        loggingAspect.logAfterReturning(mockJoinPoint, null);

        // Verify: Ensure the logger's info method was called with correct message and arguments
        verify(mockLogger).info("Exiting method: {} with result: {}", "testMethod", null);
    }

    /**
     * Test the {@link LoggingAspect#logBefore(JoinPoint)} method with no arguments.
     * This test ensures that methods with no arguments are logged correctly.
     */
    @Test
    void testLogBeforeWithNoArguments() {
        // Setup: Mock JoinPoint and Signature
        when(mockJoinPoint.getArgs()).thenReturn(new Object[]{}); // Mock no arguments

        // Call the method to test
        loggingAspect.logBefore(mockJoinPoint);

        // Verify: Ensure the logger's info method was called with correct message and arguments
        verify(mockLogger).info("Entering method: {} with arguments: {}", "testMethod", new Object[]{});
    }
}