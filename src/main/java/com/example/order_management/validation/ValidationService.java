package com.example.order_management.validation;

import com.example.order_management.infrastructure.exception.BusinessException;

public class ValidationService {
    public static void validateEmailIsAvailable(boolean customerExists) {
        if (customerExists) {
            throw new BusinessException(Error.EMAIL_UNAVAILABLE.getMessage(), Error.EMAIL_UNAVAILABLE.getErrorCode());
        }
    }

    public static void validateSkuCodeIsAvailable(boolean productExists) {
        if (productExists) {
            throw new BusinessException(Error.PRODUCT_UNAVAILABLE.getMessage(), Error.PRODUCT_UNAVAILABLE.getErrorCode());
        }
    }

    public static void validateOrderExists(boolean orderExists) {
        if (!orderExists) {
            throw new BusinessException(Error.ORDERS_NOT_FOUND.getMessage(), Error.ORDERS_NOT_FOUND.getErrorCode());
        }
    }
}
