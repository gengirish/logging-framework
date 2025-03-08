package com.example.loggingframework.controller;

import com.example.loggingframework.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The LogController class is a Spring REST controller that handles HTTP requests
 * for processing input strings.
 *
 * <p>
 * This class is annotated with {@link org.springframework.web.bind.annotation.RestController}
 * to indicate that it is a Spring-managed REST controller. It exposes an endpoint
 * to process input strings using the {@link LogService} service.
 * </p>
 *
 * <p>
 * The controller maps HTTP GET requests to the {@code /process} endpoint and delegates
 * the processing logic to the {@link LogService#performAction(String)} method.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 * @see org.springframework.web.bind.annotation.RestController
 * @see org.springframework.web.bind.annotation.GetMapping
 * @see org.springframework.web.bind.annotation.RequestParam
 * @see LogService
 */
@RestController
public class LogController {

    @Autowired
    private LogService demoService;

    /**
     * Processes the input string and returns the result.
     *
     * <p>
     * This method handles HTTP GET requests to the {@code /process} endpoint. It accepts
     * a query parameter {@code input} and delegates the processing to the {@link LogService#performAction(String)}
     * method.
     * </p>
     *
     * @param input The input string to be processed. Must not be {@code null}.
     * @return A string representing the processed input.
     * @throws IllegalArgumentException If the input is {@code null}.
     * @see LogService#performAction(String)
     */
    @GetMapping("/process")
    public String processInput(@RequestParam String input) {
        return demoService.performAction(input);
    }
}