package com.etiqaassessment.Controller;

import com.etiqaassessment.Service.ProductService;
import com.etiqaassessment.domain.Product;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    // Constructor Injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // POST (Create new product)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> addNewProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.insertProduct(product));
    }

    // PUT (Update whole product)
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                 @Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    // PATCH (Partial update)
    @PatchMapping("/{id}")
    public ResponseEntity<Product> patchProduct(@PathVariable Long id,
                             @Valid @RequestBody Product product) {

        return ResponseEntity.ok(productService.patchProduct(id, product));

    }
}
