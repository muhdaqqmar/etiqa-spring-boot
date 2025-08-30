package com.etiqaassessment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.Set;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @GetMapping
    public Set<Customers> getCustomers() {

        return Set.of(
                new Customers(
                        1,
                        "Muhammad Aqqmar",
                        "Zulkarnain",
                        "muhdaqqmar@gmail.com",
                        "0172979003"
                ),
                new Customers(
                        2,
                        "Aiman",
                        "Sopie",
                        "aiman@mail.com",
                        "0191119191"
                )
        );
    }

}
