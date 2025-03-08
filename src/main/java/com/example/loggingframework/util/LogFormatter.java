package com.example.loggingframework.util;


/**
 * The LogFormatter class provides utility methods for formatting log messages.
 *
 * <p>
 * This class contains a static method to format log messages by adding a log level
 * prefix in a standardized format.
 * </p>
 *
 * <p>
 * The formatted log message follows the pattern: {@code [LEVEL] message}, where
 * {@code LEVEL} is the log level (e.g., INFO, DEBUG, ERROR) in uppercase.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
public class LogFormatter {

    /**
     * Formats a log message by adding a log level prefix.
     *
     * <p>
     * The log level is converted to uppercase and prefixed to the message in the format:
     * {@code [LEVEL] message}.
     * </p>
     *
     * @param level   The log level (e.g., INFO, DEBUG, ERROR).
     * @param message The content of the log message.
     * @return A formatted log message in the format {@code [LEVEL] message}.
     * @throws IllegalArgumentException If either {@code level} or {@code message} is {@code null}.
     */
    public static String formatLogMessage(String level, String message) {
        if (level == null || message == null) {
            throw new IllegalArgumentException("Level and message must not be null");
        }
        return String.format("[%s] %s", level.toUpperCase(), message);
    }
}
