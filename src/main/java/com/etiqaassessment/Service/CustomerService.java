package com.etiqaassessment.Service;

import com.etiqaassessment.domain.Customer;
import com.etiqaassessment.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void insertCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomersById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found with id " + id));
    }
}
