package com.etiqaassessment.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Long id;

    @NotNull(message = "Quantity must not be null")
    private Integer quantity;

    @NotNull(message = "Customer ID must not be null")
    @JsonProperty("customer_id")
    private Integer customerId;

    @NotNull(message = "Product ID must not be null")
    @JsonProperty("product_id")
    private Long productId;

    private String customerName;   // for response
    private String productTitle;   // for response

    // Custom constructor for queries
    public OrderDTO(Long id, Integer quantity, String customerName, String productTitle) {
        this.id = id;
        this.quantity = quantity;
        this.customerName = customerName;
        this.productTitle = productTitle;
    }

    // No-args constructor is still available (Jackson needs it)
    public OrderDTO() {}
}
