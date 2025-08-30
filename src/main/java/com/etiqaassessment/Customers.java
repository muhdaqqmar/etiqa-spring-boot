package com.etiqaassessment;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Customers {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Customers() {
    }

    public Customers(Integer id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return Objects.equals(id, customers.id) && Objects.equals(firstName, customers.firstName) && Objects.equals(lastName, customers.lastName) && Objects.equals(email, customers.email) && Objects.equals(phone, customers.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phone);
    }
}
