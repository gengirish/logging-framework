package com.example.loggingframework.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder;
import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The LoggingConfig class is a Spring configuration class that provides beans for
 * integrating with external monitoring and logging services, such as StatsD and Amazon CloudWatch.
 *
 * <p>
 * This class defines two beans:
 * <ul>
 *   <li>{@link StatsDClient}: A client for sending metrics to a StatsD server.</li>
 *   <li>{@link AmazonCloudWatch}: A client for interacting with Amazon CloudWatch to publish custom metrics.</li>
 * </ul>
 * </p>
 *
 * <p>
 * The {@link StatsDClient} bean is configured to connect to a StatsD server running on `localhost`
 * at port `8125`, with the metric prefix set to `myapp`.
 * </p>
 *
 * <p>
 * The {@link AmazonCloudWatch} bean is configured using the default AWS SDK client builder,
 * which automatically picks up AWS credentials and region from the environment.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @see StatsDClient
 * @see AmazonCloudWatch
 * @see NonBlockingStatsDClient
 * @see AmazonCloudWatchClientBuilder
 * @since 2023-10-01
 */
@Configuration
public class LoggingConfig {

    /**
     * Creates and configures a {@link StatsDClient} bean for sending metrics to a StatsD server.
     *
     * <p>
     * The client is configured to:
     * <ul>
     *   <li>Use the prefix `myapp` for all metrics.</li>
     *   <li>Connect to a StatsD server running on `localhost` at port `8125`.</li>
     * </ul>
     * </p>
     *
     * @return A configured {@link StatsDClient} instance.
     */
    @Bean
    public StatsDClient statsDClient() {
        return new NonBlockingStatsDClient("myapp", "localhost", 8125);
    }

    /**
     * Creates and configures an {@link AmazonCloudWatch} bean for interacting with Amazon CloudWatch.
     *
     * <p>
     * The client is configured using the default AWS SDK client builder, which automatically
     * picks up AWS credentials and region from the environment (e.g., AWS credentials file,
     * environment variables, or IAM roles).
     * </p>
     *
     * @return A configured {@link AmazonCloudWatch} instance.
     */
    @Bean
    public AmazonCloudWatch amazonCloudWatch() {
        return AmazonCloudWatchClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        "http://localhost:8125", "us-east-1")) // LocalStack endpoint
                .build();
    }


}