package com.example.order_management.domain.product;

import com.example.order_management.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Resource
    private ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void validateSkuCodeIsAvailable(Integer skuCode) {
        boolean productExists = productRepository.productExistBy(skuCode);
        ValidationService.validateSkuCodeIsAvailable(productExists);
    }

    public Product findProductBy(Integer skuCode) {
        return productRepository.findProductBy(skuCode);
    }
}
