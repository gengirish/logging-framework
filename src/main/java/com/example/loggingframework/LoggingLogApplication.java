package com.example.loggingframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Logging Framework Spring Boot application.
 * <p>
 * This class is annotated with {@link org.springframework.boot.autoconfigure.SpringBootApplication},
 * which enables auto-configuration, component scanning, and other Spring Boot features.
 * </p>
 * <p>
 * The {@link #main(String[])} method is the starting point of the application. It initializes
 * the Spring Boot application context and starts the embedded server.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@SpringBootApplication
public class LoggingLogApplication {

	/**
	 * The main method that starts the Spring Boot application.
	 * <p>
	 * This method uses {@link SpringApplication#run(Class, String...)} to bootstrap the application.
	 * </p>
	 *
	 * @param args Command-line arguments passed to the application. These can be used to customize
	 *             the application's behavior or configuration.
	 */
	public static void main(String[] args) {
		SpringApplication.run(LoggingLogApplication.class, args);
	}
}