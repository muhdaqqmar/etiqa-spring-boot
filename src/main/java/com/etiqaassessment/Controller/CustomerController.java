package com.etiqaassessment.Controller;

import com.etiqaassessment.Service.CustomerService;
import com.etiqaassessment.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomer();
    }

    @PostMapping
    public void addNewCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    @GetMapping("{id}")
    public Customer getCustomersById(
            @PathVariable Integer id
    ) {

        return customerService.getCustomersById(id);
    }

}
