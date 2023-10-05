package com.example.order_management.business.order;

import com.example.order_management.domain.order.OrderDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrdersController {
    @Resource
    private OrdersService ordersService;

    @PostMapping("/order")
    @Operation(summary = "Adds new customer order to database and returns customerOrderId.")
    public CustomerOrderResponse createNewCustomerOrder(@RequestParam Integer customerId) {
        return ordersService.createNewCustomerOrder(customerId);
    }

    @PostMapping("/orderline")
    @Operation(summary = "Adds orderline to Order")
    public void addOrderLine(@RequestParam Integer customerOrderId, @RequestParam Integer skuCode, @RequestParam Integer quantity) {
        ordersService.addOrderLine(customerOrderId, skuCode, quantity);
    }

    @GetMapping("/orders")
    @Operation(summary = "Finds all orderds by date")
    public List<OrderDto> findAllOrdersByDate(@RequestParam LocalDate date) {
        return ordersService.findAllOrdersByDate(date);
    }
}
