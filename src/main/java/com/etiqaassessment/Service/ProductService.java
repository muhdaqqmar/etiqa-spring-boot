package com.etiqaassessment.Service;

import com.etiqaassessment.domain.Product;
import com.etiqaassessment.exception.ResourceNotFoundException;
import com.etiqaassessment.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    // Constructor Injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    // Insert new product
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    // Update whole product
    public Product updateProduct(Long id,Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        existingProduct.setBookTitle(product.getBookTitle());
        existingProduct.setBookPrice(product.getBookPrice());
        return productRepository.save(existingProduct);
    }

    // Patch product (partial update)
    public Product patchProduct(Long id, @Valid Product product) {
        // 1. Find existing product
        Product existingProduct = getProductById(id);

        // 2. Update only non-null fields
        if (product.getBookTitle() != null) {
            existingProduct.setBookTitle(product.getBookTitle());
        }
        if (product.getBookPrice() != null) {
            existingProduct.setBookPrice(product.getBookPrice());
        }

        // 3. Save updated entity
        productRepository.save(existingProduct);
        return existingProduct;
    }
}
