package org.hades.inventory.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryJpaRepository extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> findByProductId(Long productId);
}
