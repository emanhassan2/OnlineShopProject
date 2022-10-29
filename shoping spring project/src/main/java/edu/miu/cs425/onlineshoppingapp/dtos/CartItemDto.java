package edu.miu.cs425.onlineshoppingapp.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A DTO for the {@link edu.miu.cs425.onlineshoppingapp.model.CartItem} entity
 */
@Data
public class CartItemDto implements Serializable {
    private final Integer cartItemId;
    private final Integer quantity;
    private final ProductDto1 product;

    /**
     * A DTO for the {@link edu.miu.cs425.onlineshoppingapp.model.Product} entity
     */
    @Data
    public static class ProductDto1 implements Serializable {
        private final Integer productId;
        @NotBlank(message = "name cannot be blank or empty or null")
        private final String name;
        private final String category;
        private final Integer quantityInStock;
        private final Double price;
        private final String description;
    }
}