package com.example.order_management.validation;

import lombok.Getter;

@Getter
public enum Error {

    EMAIL_UNAVAILABLE("This email is already in use", 111),
    PRODUCT_UNAVAILABLE("This product already exists", 222);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}
