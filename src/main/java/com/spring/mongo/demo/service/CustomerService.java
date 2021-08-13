package com.spring.mongo.demo.service;

import com.spring.mongo.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<?> findAll();

    Customer findById(String id);

    Customer save(Customer superHero);


    void delete(String id);
}
