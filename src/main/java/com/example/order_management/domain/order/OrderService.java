package com.example.order_management.domain.order;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> findOrdersBy(LocalDate date) {
        return orderRepository.findOrdersBy(date);
    }

    public boolean orderExistsBy(LocalDate date) {
        return orderRepository.orderExistsBy(date);
    }
}
