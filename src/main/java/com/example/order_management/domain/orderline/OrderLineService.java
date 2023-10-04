package com.example.order_management.domain.orderline;

import com.example.order_management.domain.orderline.OrderLine;
import com.example.order_management.domain.orderline.OrderLineRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {
    @Resource
    OrderLineRepository orderLineRepository;
    public void saveOrderLine(OrderLine orderLine) {
        orderLineRepository.save(orderLine);
    }
}
