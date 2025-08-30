package com.etiqaassessment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="product")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name="book_title", nullable=false) private String bookTitle;
    @Column(name="book_price", nullable=false) private BigDecimal bookPrice;
    @Column(name="book_quantity", nullable=false) private Integer bookQuantity;

    public Product() {
    }

    public Product(Integer bookQuantity, BigDecimal bookPrice, Long id, String bookTitle) {
        this.bookQuantity = bookQuantity;
        this.bookPrice = bookPrice;
        this.id = id;
        this.bookTitle = bookTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(bookTitle, product.bookTitle) && Objects.equals(bookPrice, product.bookPrice) && Objects.equals(bookQuantity, product.bookQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookTitle, bookPrice, bookQuantity);
    }
}
