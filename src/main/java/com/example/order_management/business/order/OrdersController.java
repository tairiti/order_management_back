package com.example.order_management.business.order;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrdersController {
    @Resource
    private OrdersService ordersService;

    @PostMapping("/order")
    @Operation(summary = "Adds new customer order to database")
    public void createNewCustomerOrder(@RequestBody OrderCreation orderCreation) {
        ordersService.createNewCustomerOrder(orderCreation);
    }

    @GetMapping("/orders")
    @Operation(summary = "Finds all orders by date")
    public List<OrderDto> findAllOrdersByDate(@RequestParam LocalDate date) {
        return ordersService.findAllOrdersByDate(date);
    }
}
