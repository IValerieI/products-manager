package com.example.demo.util;

public class ExceptionStringUtil {

    private ExceptionStringUtil() {
        throw new IllegalStateException("Attempt to initialize object of util-class: " + ExceptionStringUtil.class.getName());
    }

    public static final String ENTITY_NOT_FOUND = "Не найдена сущность: %s с параметрами: %s";

    public static final String SELLER_ID = "seller_id";

    public static final String CUSTOMER_ID = "customer_id";

    public static final String PRODUCT_ID = "product_id";

}
