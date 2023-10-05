package com.example.order_management.business.product;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {
    @Resource
    private ProductsService productsService;

    @PostMapping("/product")
    @Operation(summary = "Adds product to database")
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productsService.createProduct(productRequest);
    }
}
