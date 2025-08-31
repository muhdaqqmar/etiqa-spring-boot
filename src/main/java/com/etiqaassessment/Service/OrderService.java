package com.etiqaassessment.Service;

import com.etiqaassessment.DTO.OrderDTO;
import com.etiqaassessment.domain.Orders;
import com.etiqaassessment.exception.ResourceNotFoundException;
import com.etiqaassessment.repository.OrdersRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;

    // Constructor injection
    public OrderService(OrdersRepository orderRepository) {
        this.ordersRepository = orderRepository;
    }

    // Get all orders
    public List<OrderDTO> getAllOrders() {
        return ordersRepository.findAll().stream().map(order -> {
            return new OrderDTO(
                    order.getOrder_id(),
                    order.getQuantity(),
                    order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName(),
                    order.getProduct().getBookTitle()
            );
        }).toList();
    }

    // Get order by ID
    public Orders getOrderById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    // Insert new order
    public Orders insertOrder(Orders order) {
        return ordersRepository.save(order);
    }

    // Update (replace all fields)
    public OrderDTO updateOrder(Long id, OrderDTO order) {
        Orders orders = getOrderById(id);
        orders.setQuantity(order.getQuantity());
        Orders saved = ordersRepository.save(orders);

        // Map back to DTO (only needed fields)
        return new OrderDTO(
                saved.getOrder_id(),
                saved.getQuantity(),
                saved.getCustomer().getFirstName() + " " + saved.getCustomer().getLastName(),
                saved.getProduct().getBookTitle()
        );
    }

    // Patch (update only non-null fields)
    public OrderDTO patchOrder(Long id, @Valid OrderDTO order) {
        Orders existingOrder = getOrderById(id);
        existingOrder.setQuantity(order.getQuantity());
        Orders saved = ordersRepository.save(existingOrder);

        // Map back to DTO (only needed fields)
        return new OrderDTO(
                saved.getOrder_id(),
                saved.getQuantity(),
                saved.getCustomer().getFirstName() + " " + saved.getCustomer().getLastName(),
                saved.getProduct().getBookTitle()
        );
    }
}
