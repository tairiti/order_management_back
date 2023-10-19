package com.example.order_management.domain.orderline;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {
    @Resource
    OrderLineRepository orderLineRepository;
    public void saveOrderLine(OrderLine orderLine) {
        orderLineRepository.save(orderLine);
    }

    public void saveOrderLines(List<OrderLine> orderLines) {
        orderLineRepository.saveAll(orderLines);
    }
}
