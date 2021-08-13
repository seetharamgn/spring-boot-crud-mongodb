package com.spring.mongo.demo.service.impl;

import com.spring.mongo.demo.model.Customer;
import com.spring.mongo.demo.repository.CustomerRepository;
import com.spring.mongo.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(String id) {
        return repository.findById(id).orElse(new Customer());
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void delete(String id) {
       repository.findById(id).ifPresent(customer -> repository.delete(customer));
    }
}
