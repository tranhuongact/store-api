package com.store.listing.utils;

import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;

import java.util.UUID;

public class Utils {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("DWEALTH");

    public static String getRandomString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static void writeLog(LogLevel logType, String message) {

        if (message.equals("Error parsing HTTP request header"))
            return;

        switch (logType) {
            case DEBUG:
                logger.debug(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            default:
                INFO:
                logger.info(message);
                break;
        }
    }

    public static void writeLog(Exception e) {
        String msg = e.getMessage() + getLogStackTrace(e.getStackTrace());
        writeLog(LogLevel.ERROR, "----ERROR----" + msg);
    }

    public static String getLogStackTrace(StackTraceElement[] elements) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : elements) {
            if (stackTraceElement.getClassName().contains("com.store"))
                sb.append("\t(")
                        .append(stackTraceElement.getFileName()).append(":")
                        .append(stackTraceElement.getLineNumber())
                        .append(")-").append(stackTraceElement.getMethodName());
        }
        return sb.toString();
    }
}
