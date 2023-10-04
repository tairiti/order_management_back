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

//    @PostMapping("/order")
//    @Operation(summary = "Adds new order to database.")
//    public void createNewOrder(@RequestParam Integer skuCode, @RequestParam Integer quantity, @RequestParam Integer customerId) {
//        ordersService.createNewOrder(skuCode, quantity, customerId);
//    }

    @PostMapping("/order")
    @Operation(summary = "Adds new customer order to database and returns customerOrderId.")
    public Integer createNewCustomerOrder(@RequestParam Integer customerId) {
        return ordersService.createNewCustomerOrder(customerId);
    }

    @PostMapping("/orderline")
    @Operation(summary = "Adds orderline to Order")
    public void addOrderLine(@RequestParam Integer customerOrderId, @RequestParam Integer skuCode, @RequestParam Integer quantity) {
        ordersService.addOrderLine(customerOrderId, skuCode, quantity);
    }
}
