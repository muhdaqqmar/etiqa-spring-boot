package com.etiqaassessment.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
@Entity
@Table(name="orders")
public class Orders {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false) // FK column in Orders table
    @NotNull(message = "Customer must not be null")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false) // FK column in Orders table
    @NotNull(message = "Product must not be null")
    private Product product;


    public Orders() {
    }

    public Orders(Long order_id, Customer customer) {
        this.order_id = order_id;
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Orders order = (Orders) o;
        return Objects.equals(order_id, order.order_id) && Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, customer);
    }

}
