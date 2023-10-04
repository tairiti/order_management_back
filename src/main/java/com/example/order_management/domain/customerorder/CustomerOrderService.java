package com.example.order_management.domain.customerorder;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {
    @Resource
    private CustomerOrderRepository customerOrderRepository;

    public void saveCustomerOrder(CustomerOrder customerOrder) {
        customerOrderRepository.save(customerOrder);
    }


    public CustomerOrder findCustomerOrderBy(Integer customerOrderId) {
        return customerOrderRepository.getReferenceById(customerOrderId);

    }
}
