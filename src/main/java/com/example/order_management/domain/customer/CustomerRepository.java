package com.example.order_management.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select (count(c) > 0) from Customer c where c.email = ?1")
    boolean customerExistsBy(String email);


}