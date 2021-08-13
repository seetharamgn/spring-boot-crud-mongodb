package com.spring.mongo.demo.controller;


import com.spring.mongo.demo.model.Customer;
import com.spring.mongo.demo.repository.CustomerRepository;
import com.spring.mongo.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = customerService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        return ResponseEntity.ok().body(customer);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        return ResponseEntity.ok().body(savedCustomer);
    }


    @Autowired
    private CustomerRepository repository;
    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer newCustomer, @PathVariable String id) {

        return repository.findById(id)
                .map(customer-> {
                    customer.setName(newCustomer.getName());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setAge(newCustomer.getAge());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        customerService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
