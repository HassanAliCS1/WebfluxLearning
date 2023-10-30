package com.demo.WebfluxLearning.controller;

import com.demo.WebfluxLearning.dto.Customer;
import com.demo.WebfluxLearning.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getAllCustomer(){
        return customerService.loadAllCustomers();
    }
}
