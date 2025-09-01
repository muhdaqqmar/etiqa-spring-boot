package com.etiqaassessment.Controller;

import com.etiqaassessment.DTO.FamilyMemberDTO;
import com.etiqaassessment.domain.FamilyMember;
import jakarta.validation.Valid;
import com.etiqaassessment.Service.CustomerService;
import com.etiqaassessment.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();
    }

    @GetMapping("{id}")
    public Customer getCustomersById(@PathVariable Integer id) {
        return customerService.getCustomersById(id);
    }

    @GetMapping("/familyMembers/{id}")
    public List<FamilyMemberDTO> getFamilyMembersById(@PathVariable Integer id) {
        return customerService.getFamilyMembers(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> addNewCustomer(@Valid @RequestBody Customer customer) {
        return  ResponseEntity.ok(customerService.insertCustomer(customer));
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(customer,id));
    }

    @PatchMapping("{id}")
    public void patchCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer) {
        customerService.patchCustomer(id,customer);
    }

    @PostMapping("/{customerId}/family-members")
    public ResponseEntity<FamilyMember> addFamilyMember(
            @PathVariable Integer customerId,
            @RequestBody FamilyMember familyMember) {
        return ResponseEntity.ok(customerService.addFamilyMember(customerId, familyMember));
    }
}
