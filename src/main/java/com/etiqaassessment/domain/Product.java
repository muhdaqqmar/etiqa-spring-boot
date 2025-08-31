package com.etiqaassessment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="product")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product_id;
    @Column(name="book_title", nullable=false)
    private String bookTitle;
    @Column(name="book_price", nullable=false)
    private BigDecimal bookPrice;

    public Product() {
    }

    public Product(BigDecimal bookPrice, Long product_id, String bookTitle) {
        this.bookPrice = bookPrice;
        this.product_id = product_id;
        this.bookTitle = bookTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(product_id, product.product_id) && Objects.equals(bookTitle, product.bookTitle) && Objects.equals(bookPrice, product.bookPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, bookTitle, bookPrice);
    }
}
