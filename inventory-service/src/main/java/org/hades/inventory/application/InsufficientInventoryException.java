package org.hades.inventory.application;

public class InsufficientInventoryException extends RuntimeException {
    public InsufficientInventoryException(Long productId) {
        super("Insufficient inventory for product id: " + productId);
    }
}
