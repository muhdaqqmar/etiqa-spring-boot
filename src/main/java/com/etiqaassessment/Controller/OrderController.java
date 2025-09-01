package com.etiqaassessment.Controller;

import com.etiqaassessment.DTO.OrderDTO;
import com.etiqaassessment.Service.CustomerService;
import com.etiqaassessment.Service.OrderService;
import com.etiqaassessment.Service.ProductService;
import com.etiqaassessment.domain.Customer;
import com.etiqaassessment.domain.Orders;
import com.etiqaassessment.domain.Product;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final ProductService productService;


    // Constructor injection
    public OrderController(OrderService orderService, CustomerService customerService, ProductService productService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }

    // Get all orders
    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get order by ID
    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Create a new order
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Orders> addNewOrder(@Valid @RequestBody OrderDTO orderDto) {
        // Fetch referenced entities
        Customer customer = customerService.getCustomersById(orderDto.getCustomerId());
        Product product = productService.getProductById(orderDto.getProductId());

        // Map DTO to entity
        Orders order = new Orders();
        order.setCustomer(customer);
        order.setProduct(product);
        order.setQuantity(orderDto.getQuantity());

        Orders savedOrder = orderService.insertOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    // Update an order completely (replace all fields)
    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderDTO orderDto) {
        // Fetch referenced entities
        return ResponseEntity.ok(orderService.updateOrder(id,orderDto));
    }

    // Patch (partial update)
    @PatchMapping("/{id}")
    public void patchOrder(@PathVariable Long id, @Valid @RequestBody OrderDTO orderDto) {
        orderService.patchOrder(id, orderDto);
    }

}
