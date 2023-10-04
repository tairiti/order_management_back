package com.example.order_management.business.order;

import com.example.order_management.domain.Order;
import com.example.order_management.domain.product.Product;
import com.example.order_management.domain.product.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrdersService {
    @Resource
    private ProductService productService;
    @Resource
    private OrderService orderService;

    public void createNewOrder(Integer skuCode, Integer quantity) {
        Order order = new Order();
        order.setSubmissionDate(LocalDate.now());
        orderService.saveOrder(order);

        Product product = productService.findProductBy(skuCode);
        Integer productId = product.getId();


    }
}
