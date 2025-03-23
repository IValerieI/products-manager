package com.example.demo.util;

public class LogFormatUtil {

    private LogFormatUtil() {
        throw new IllegalStateException("Attempt to initialize object of util-class: " + ExceptionStringUtil.class.getName());
    }

    public static final String HANDLER_ERROR_INFO_FORMAT = "{}{}. {}";
    public static final String HANDLER_ERROR_DEBUG_FORMAT = "%s%s. %s";
    public static final String ERROR_FOR_LOG = "Error. ";
}
