package com.society.OrderIn.service.impl;

import com.society.OrderIn.model.Customer;
import com.society.OrderIn.repo.CustomerRepo;
import com.society.OrderIn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public Optional<Customer> getOrders(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public List<Customer> getAllOrders() {
        return customerRepo.findAll();
    }

    @Override
    public Customer addOrders(Customer customer) {
        customerRepo.save(customer);
        return customer;
    }

    @Override
    public Customer deleteOrder(Customer customer) {
        customerRepo.delete(customer);
        return customer;
    }

    @Override
    public Customer updateOrder(Customer customer) {
        customerRepo.save(customer);
        return customer;
    }
}
