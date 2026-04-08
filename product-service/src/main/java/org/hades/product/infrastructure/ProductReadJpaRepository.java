package org.hades.product.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReadJpaRepository extends JpaRepository<ProductEntity, Long> {
}
