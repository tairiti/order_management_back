package com.example.order_management.domain;

import com.example.order_management.business.CustomerRequest;
import com.example.order_management.domain.customer.Customer;
import com.example.order_management.domain.customer.CustomerRepository;
import com.example.order_management.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {

    @Resource
    private CustomerRepository customerRepository;


    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void validateEmailIsAvailable(String email) {
        boolean customerExists = customerRepository.customerExistsBy(email);
        ValidationService.validateEmailIsAvailable(customerExists);
    }
}
