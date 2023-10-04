package com.example.order_management.domain.orderorderline;

import com.example.order_management.domain.orderorderline.OrderOrderLine;
import com.example.order_management.domain.orderorderline.OrderOrderLineRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderOrderLineService {
    @Resource
    private OrderOrderLineRepository orderOrderLineRepository;

    public void saveOrderOrderLine(OrderOrderLine orderOrderLine) {
        orderOrderLineRepository.save(orderOrderLine);
    }
}
