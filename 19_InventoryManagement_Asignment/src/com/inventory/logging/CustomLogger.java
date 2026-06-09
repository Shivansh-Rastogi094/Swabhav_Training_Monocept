package com.inventory.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static String getFormattedTime() {
        return LocalDateTime.now().format(formatter);
    }

    public static void info(String className, String message) {
        System.out.printf("[%s] [INFO] [%s] %s%n", getFormattedTime(), className, message);
    }

    public static void warning(String className, String message) {
        System.out.printf("[%s] [WARNING] [%s] %s%n", getFormattedTime(), className, message);
    }

    public static void error(String className, String message) {
        System.err.printf("[%s] [ERROR] [%s] %s%n", getFormattedTime(), className, message);
    }
}
