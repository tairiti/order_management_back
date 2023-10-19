package com.example.order_management.business.order;

import com.example.order_management.domain.orderline.OrderLine;
import com.example.order_management.domain.product.OrderProducts;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link OrderLine}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreation implements Serializable {
    @NotNull
    private Integer customerId;
    @NotNull
    private List<OrderProducts> products;

}