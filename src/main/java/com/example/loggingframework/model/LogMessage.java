package com.example.loggingframework.model;

/**
 * The LogMessage class represents a log message with a log level and a message content.
 *
 * <p>
 * This class is a simple model that encapsulates the properties of a log message,
 * including the log level (e.g., INFO, DEBUG, ERROR) and the message content.
 * </p>
 *
 * <p>
 * It provides constructors, getters, and setters for accessing and modifying the log level
 * and message content.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
public class LogMessage {

    private String level;
    private String message;

    /**
     * Default constructor for creating an empty LogMessage instance.
     */
    public LogMessage() {
    }

    /**
     * Parameterized constructor for creating a LogMessage instance with the specified log level and message.
     *
     * @param level   The log level (e.g., INFO, DEBUG, ERROR).
     * @param message The content of the log message.
     */
    public LogMessage(String level, String message) {
        this.level = level;
        this.message = message;
    }

    /**
     * Returns the log level of the message.
     *
     * @return The log level (e.g., INFO, DEBUG, ERROR).
     */
    public String getLevel() {
        return level;
    }

    /**
     * Sets the log level of the message.
     *
     * @param level The log level to set (e.g., INFO, DEBUG, ERROR).
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Returns the content of the log message.
     *
     * @return The content of the log message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the content of the log message.
     *
     * @param message The content to set for the log message.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
