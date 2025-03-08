package com.example.loggingframework;

import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class for {@link LoggingLogApplication}.
 * This class contains unit tests to ensure that the Spring Boot application context loads successfully
 * and that the main method runs without throwing exceptions.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE) // Disable web environment
@ExtendWith(SpringExtension.class)
class LoggingLogApplicationTest {

    @MockBean
    private AmazonCloudWatch amazonCloudWatch;

    /**
     * Test to verify that the Spring application context loads successfully.
     * This test ensures that the Spring Boot application starts and initializes the context correctly.
     *
     * @param context The Spring application context injected by Spring Boot Test.
     */
    @Test
    void contextLoads(ApplicationContext context) {
        // Verify that the application context is not null
        assertNotNull(context, "Application context should not be null");
    }

    /**
     * Test to verify that the main method runs without throwing exceptions.
     * This test ensures that the application can be started using the main method.
     */
    @Test
    void testMainMethod() {
        // Call the main method and ensure it runs without throwing exceptions
        LoggingLogApplication.main(new String[]{});
    }
}