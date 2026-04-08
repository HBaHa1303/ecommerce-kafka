package org.hades.inventory.application;

public class InventoryNotFoundException extends  RuntimeException{
    public InventoryNotFoundException(Long productId) {
        super("Inventory not found for product id: " + productId);
    }
}
