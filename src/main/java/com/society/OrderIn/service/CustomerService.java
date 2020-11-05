package com.society.OrderIn.service;

import com.society.OrderIn.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Customer> getOrders(int id);
    List<Customer> getAllOrders();
    Customer addOrders(Customer customer);
    Customer deleteOrder(Customer customer);
    Customer updateOrder(Customer customer);

}
