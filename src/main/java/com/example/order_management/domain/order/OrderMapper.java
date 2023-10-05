package com.example.order_management.domain.order;

import com.example.order_management.business.order.OrderDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrderDtos(List<Order> orders);

}