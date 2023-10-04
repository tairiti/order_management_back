package com.example.order_management.business.order;

import com.example.order_management.domain.customerorder.CustomerOrder;
import com.example.order_management.domain.customerorder.CustomerOrderService;
import com.example.order_management.domain.order.Order;
import com.example.order_management.domain.order.OrderService;
import com.example.order_management.domain.orderline.OrderLine;
import com.example.order_management.domain.orderline.OrderLineService;
import com.example.order_management.domain.customer.Customer;
import com.example.order_management.domain.customer.CustomerService;
import com.example.order_management.domain.orderorderline.OrderOrderLine;
import com.example.order_management.domain.orderorderline.OrderOrderLineService;
import com.example.order_management.domain.product.Product;
import com.example.order_management.domain.product.ProductService;
import jakarta.annotation.Resource;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrdersService {
    @Resource
    private ProductService productService;
    @Resource
    private OrderService orderService;
    @Resource
    private OrderLineService orderLineService;
    @Resource
    private OrderOrderLineService orderOrderLineService;
    @Resource
    private CustomerService customerService;
    @Resource
    private CustomerOrderService customerOrderService;

//    public void createNewOrder(Integer skuCode, Integer quantity, Integer customerId) {
//        Order order = new Order();
//        order.setSubmissionDate(LocalDate.now());
//        orderService.saveOrder(order);
//
//        Customer customer = customerService.findCustomerBy(customerId);
//        CustomerOrder customerOrder = new CustomerOrder();
//        customerOrder.setCustomer(customer);
//        customerOrder.setOrder(order);
//        customerOrderService.saveCustomerOrder(customerOrder);
//
//        Product product = productService.findProductBy(skuCode);
//
//        OrderLine orderLine = new OrderLine();
//        orderLine.setQuantity(quantity);
//        orderLine.setProduct(product);
//        orderLineService.saveOrderLine(orderLine);
//
//        OrderOrderLine orderOrderLine = new OrderOrderLine();
//        orderOrderLine.setOrder(order);
//        orderOrderLine.setOrderLine(orderLine);
//        orderOrderLineService.saveOrderOrderLine(orderOrderLine);
//    }
    public Integer createNewCustomerOrder(Integer customerId) {
        Order order = new Order();
        order.setSubmissionDate(LocalDate.now());
        orderService.saveOrder(order);

        Customer customer = customerService.findCustomerBy(customerId);
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setOrder(order);
        customerOrderService.saveCustomerOrder(customerOrder);
        return customerOrder.getId();
    }

    public void addOrderLine(Integer customerOrderId, Integer skuCode, Integer quantity) {
        CustomerOrder customerOrder = customerOrderService.findCustomerOrderBy(customerOrderId);
        Order order = customerOrder.getOrder();

        Product product = productService.findProductBy(skuCode);

        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(product);
        orderLine.setQuantity(quantity);
        orderLineService.saveOrderLine(orderLine);

        OrderOrderLine orderOrderLine = new OrderOrderLine();
        orderOrderLine.setOrder(order);
        orderOrderLine.setOrderLine(orderLine);
        orderOrderLineService.saveOrderOrderLine(orderOrderLine);
    }
}
