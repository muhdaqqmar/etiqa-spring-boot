package com.etiqaassessment.Service;

import com.etiqaassessment.DTO.FamilyMemberDTO;
import com.etiqaassessment.domain.Customer;
import com.etiqaassessment.domain.FamilyMember;
import com.etiqaassessment.exception.GlobalExceptionHandler;
import com.etiqaassessment.exception.ResourceNotFoundException;
import com.etiqaassessment.repository.CustomerRepository;
import com.etiqaassessment.repository.FamilyMembersRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FamilyMembersRepository familyMembersRepository;

    public CustomerService(CustomerRepository customerRepository, List<FamilyMember> familyMemberRepository, FamilyMembersRepository familyMembersRepository) {
        this.customerRepository = customerRepository;
        this.familyMembersRepository = familyMembersRepository;
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomersById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }

    public List<FamilyMemberDTO> getFamilyMembers(Integer id) {
        return  familyMembersRepository.findByCustomerId(id)
                .stream()
                .map(f -> new FamilyMemberDTO(f.getFamily_member_id(), f.getName(), f.getRelation()))
                .toList();
    }

    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer, Integer id) {
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setFirstName(customer.getFirstName());
                    existingCustomer.setLastName(customer.getLastName());
                    existingCustomer.setEmail(customer.getEmail());
                    existingCustomer.setPhone(customer.getPhone());
                    return customerRepository.save(existingCustomer);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }

    public void patchCustomer(Integer id, @Valid Customer customer) {
        // 1. Find existing customer
        Customer existingCustomer = getCustomersById(id);

        // 2. Update only fields that are not null in the request
        if (customer.getFirstName() != null) {
            existingCustomer.setFirstName(customer.getFirstName());
        }
        if (customer.getLastName() != null) {
            existingCustomer.setLastName(customer.getLastName());
        }
        if (customer.getEmail() != null) {
            existingCustomer.setEmail(customer.getEmail());
        }
        if (customer.getPhone() != null) {
            existingCustomer.setPhone(customer.getPhone());
        }

        // 3. Save updated entity
        customerRepository.save(existingCustomer);
    }

    public FamilyMember addFamilyMember(Integer customerId, FamilyMember familyMember) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Set the relation
        familyMember.setCustomer(customer);

        // Save the customer (cascade = ALL takes care of saving the family member)
        return familyMembersRepository.save(familyMember);
    }
}
