package com.example.order_management.business.order;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
    @Resource
    private OrdersService ordersService;
    @PostMapping("/order")
    @Operation(summary = "Adds new order to database.")
    public void createNewOrder(@RequestParam Integer skuCode, @RequestParam Integer quantity) {
        ordersService.createNewOrder(skuCode, quantity);
    }
}
