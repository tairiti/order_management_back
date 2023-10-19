package com.example.order_management.domain.product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProducts implements Serializable {
    @NotNull
    private Integer productId;
    @NotNull
    private Integer productQuantity;
}