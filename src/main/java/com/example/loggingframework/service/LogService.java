package com.example.loggingframework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * The LogService class is a service component that performs actions and logs the process
 * using SLF4J logging framework.
 *
 * <p>
 * This class is annotated with {@link org.springframework.stereotype.Service} to indicate
 * that it is a Spring-managed service component. It provides a method to perform an action
 * on a given input and logs the process at the debug level.
 * </p>
 *
 * <p>
 * If the input is {@code null}, the method throws an {@link IllegalArgumentException}.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 * @see org.slf4j.Logger
 * @see org.slf4j.LoggerFactory
 */
@Service
public class LogService {

    private final Logger logger = LoggerFactory.getLogger(LogService.class);

    /**
     * Performs an action on the given input and logs the process.
     *
     * <p>
     * This method logs the input at the debug level using the SLF4J logger. If the input
     * is {@code null}, an {@link IllegalArgumentException} is thrown.
     * </p>
     *
     * @param input The input string to be processed. Must not be {@code null}.
     * @return A string representing the processed input.
     * @throws IllegalArgumentException If the input is {@code null}.
     */
    public String performAction(String input) {
        logger.debug("Performing action with input: {}", input);
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return "Processed: " + input;
    }
}