package com.example.demo.util;

public class ErrorTitleUtil {

    private ErrorTitleUtil() {
        throw new IllegalStateException("Attempt to initialize object of util-class: " + ExceptionStringUtil.class.getName());
    }

    public static final String BAD_REQUEST = "Введенные данные некорректны";
    public static final String NOT_FOUND = "404 Not found";
}
