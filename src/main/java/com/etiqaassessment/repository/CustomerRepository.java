package com.etiqaassessment.repository;

import com.etiqaassessment.domain.Customer;
import com.etiqaassessment.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}

