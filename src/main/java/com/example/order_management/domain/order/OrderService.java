package com.example.order_management.domain.order;

import com.example.order_management.domain.order.Order;
import com.example.order_management.domain.order.OrderRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Resource
    private OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
