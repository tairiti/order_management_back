package com.example.order_management.business.order;

import com.example.order_management.domain.customerorder.CustomerOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link CustomerOrder}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderResponse implements Serializable {
    private Integer customerOrderId;
}