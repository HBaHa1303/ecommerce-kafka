package org.hades.inventory.application;

import lombok.RequiredArgsConstructor;
import org.hades.inventory.presentation.OrderCreatedEvent;

@RequiredArgsConstructor
public class ReverseStockCommandHandler {
    private final InventoryRepository repository;

    public void reverseStock(OrderCreatedEvent event) {
        event.getOrderItems().forEach(item -> {
            Inventory inventory = repository.findByProductId(item.getProductId())
                    .orElseThrow(() -> new InventoryNotFoundException(item.getProductId()));
            inventory.reduceInventory(Long.valueOf(item.getQuantity()));
            repository.save(inventory);
        });
    }
}
