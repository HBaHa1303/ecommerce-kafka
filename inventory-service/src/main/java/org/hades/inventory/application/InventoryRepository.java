package org.hades.inventory.application;

import java.util.Optional;

public interface InventoryRepository {
    Optional<Inventory> findByProductId(Long productId);
    void save(Inventory inventory);
}
