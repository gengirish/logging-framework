package com.example.loggingframework.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The LoggingAspect class is an Aspect-Oriented Programming (AOP) aspect that provides logging
 * functionality for methods in the service layer of the application. It logs method entry, exit,
 * and exceptions using SLF4J.
 *
 * This aspect is applied to all methods in the `com.example.loggingdemo.service` package.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Logs the entry of a method in the service layer, including the method name and arguments.
     *
     * @param joinPoint The JoinPoint object representing the method being executed.
     */
    @Before("execution(* com.example.loggingframework.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering method: {} with arguments: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    /**
     * Logs the successful exit of a method in the service layer, including the method name and the result.
     *
     * @param joinPoint The JoinPoint object representing the method being executed.
     * @param result The result returned by the method.
     */
    @AfterReturning(pointcut = "execution(* com.example.loggingframework.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Exiting method: {} with result: {}", joinPoint.getSignature().getName(), result);
    }

    /**
     * Logs any exceptions thrown by a method in the service layer, including the method name and the error message.
     *
     * @param joinPoint The JoinPoint object representing the method being executed.
     * @param error The exception thrown by the method.
     */
    @AfterThrowing(pointcut = "execution(* com.example.loggingframework.service.*.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("Exception in method: {} with cause: {}", joinPoint.getSignature().getName(), error.getMessage());
    }
}