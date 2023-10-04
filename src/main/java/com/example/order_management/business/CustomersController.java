package com.example.order_management.business;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomersController {
    @Resource
    private CustomersService customersService;

    @PostMapping("/customer")
    public void addCustomer(@RequestBody CustomerRequest customerRequest) {
        customersService.addCustomer(customerRequest);
    }


}
