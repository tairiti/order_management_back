package com.example.order_management.domain.order;

import com.example.order_management.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {



    @Query("select o from Order o where o.submissionDate = ?1")
    List<Order> findOrdersBy(LocalDate submissionDate);


    @Query("select (count(o) > 0) from Order o where o.submissionDate = ?1")
    boolean orderExistsBy(LocalDate submissionDate);
}