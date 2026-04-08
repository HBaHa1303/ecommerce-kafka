package org.hades.inventory.application;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Inventory {
    private final Long id;
    private final Long productId;
    private Long quantity;

    public Inventory(Long id, Long productId, Long quantity) {
        Objects.requireNonNull(productId, "ProductId cannot be null");
        Objects.requireNonNull(quantity, "Quantity cannot be null");

        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public static Inventory create (Long productId, Long quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        return new Inventory(null, productId, quantity);
    }

    public static Inventory reconstitute(Long id, Long productId, Long quantity) {
        return new Inventory(id, productId, quantity);
    }

    public void reduceInventory (Long quantity) {
        Objects.requireNonNull(quantity, "Quantity cannot be null");
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        if (this.quantity < quantity) {
            throw new InsufficientInventoryException(this.productId);
        }

        this.quantity = this.quantity - quantity;
    }
}
