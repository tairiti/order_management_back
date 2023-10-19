package com.example.order_management.business.order;

import com.example.order_management.domain.customerorder.CustomerOrder;
import com.example.order_management.domain.customerorder.CustomerOrderService;
import com.example.order_management.domain.order.Order;
import com.example.order_management.domain.order.OrderMapper;
import com.example.order_management.domain.order.OrderService;
import com.example.order_management.domain.orderline.OrderLine;
import com.example.order_management.domain.orderline.OrderLineService;
import com.example.order_management.domain.customer.Customer;
import com.example.order_management.domain.customer.CustomerService;
import com.example.order_management.domain.orderorderline.OrderOrderLine;
import com.example.order_management.domain.orderorderline.OrderOrderLineService;
import com.example.order_management.domain.product.OrderProducts;
import com.example.order_management.domain.product.Product;
import com.example.order_management.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
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
    @Resource
    private OrderMapper orderMapper;

    public void createNewCustomerOrder(OrderCreation orderCreation) {
        Order order = createAndSaveOrder();
        Customer customer = customerService.findCustomerBy(orderCreation.getCustomerId());
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setOrder(order);
        customerOrderService.saveCustomerOrder(customerOrder);

        List<OrderProducts> products = orderCreation.getProducts();
        List<OrderLine> orderLines = new ArrayList<>();

        for (OrderProducts productInfo : products) {
            OrderLine orderLine = new OrderLine();
            Product product = new Product();
            product.setId(productInfo.getProductId());

            orderLine.setProduct(product);
            orderLine.setQuantity(productInfo.getProductQuantity());
            orderLines.add(orderLine);
        }
        orderLineService.saveOrderLines(orderLines);

        for (OrderLine orderLine : orderLines) {
            OrderOrderLine orderOrderLine = new OrderOrderLine();
            orderOrderLine.setOrder(order);
            orderOrderLine.setOrderLine(orderLine);
            orderOrderLineService.saveOrderOrderLine(orderOrderLine);
        }

    }
    private Order createAndSaveOrder() {
        Order order = new Order();
        order.setSubmissionDate(LocalDate.now());
        orderService.saveOrder(order);
        return order;
    }
    public List<OrderDto> findAllOrdersByDate(LocalDate date) {
        boolean orderExists = orderService.orderExistsBy(date);
        ValidationService.validateOrderExists(orderExists);
        List<Order> orders = orderService.findOrdersBy(date);
        return orderMapper.toOrderDtos(orders);
    }
}