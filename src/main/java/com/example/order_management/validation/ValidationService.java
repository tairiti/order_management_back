package com.example.order_management.validation;

import com.example.order_management.infrastructure.exception.BusinessException;

public class ValidationService {
    public static void validateEmailIsAvailable(boolean customerExists) {
        if (customerExists) {
            throw new BusinessException(Error.EMAIL_UNAVAILABLE.getMessage(), Error.EMAIL_UNAVAILABLE.getErrorCode());
        }
    }
}
