package org.hades.inventory.infrastructure;

import lombok.RequiredArgsConstructor;
import org.hades.inventory.application.Inventory;
import org.hades.inventory.application.InventoryRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InventoryPort implements InventoryRepository {
    private final InventoryJpaRepository repository;
    private final IInventoryMapper mapper;

    @Override
    public Optional<Inventory> findByProductId(Long productId) {
        return repository.findByProductId(productId)
                .map(i -> Inventory.reconstitute(i.getId(), i.getProductId(), i.getQuantity()));
    }

    @Override
    public void save(Inventory inventory) {
        InventoryEntity inventoryEntity = mapper.domainToEntity(inventory);
        repository.save(inventoryEntity);
    }
}
