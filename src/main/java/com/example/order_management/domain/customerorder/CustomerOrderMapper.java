package com.example.order_management.domain.customerorder;

import com.example.order_management.business.order.CustomerOrderResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerOrderMapper {

    @Mapping(source = "id", target = "customerOrderId")
    CustomerOrderResponse toCustomerOrderResponse(CustomerOrder customerOrder);
}