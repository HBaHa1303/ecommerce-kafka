package org.hades.product.infrastructure;

import lombok.RequiredArgsConstructor;
import org.hades.product.application.projection.ProductProjection;
import org.hades.product.application.repository.ProductReadRepository;
import org.hades.product.presentation.ProductResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductReadRepositoryPort implements ProductReadRepository {
    private final ProductReadJpaRepository repository;
    private final IProductMapper iProductMapper;

    @Override
    public List<ProductProjection> getProductsByIds(List<Long> ids) {
        return repository.findAllById(ids).stream().map(iProductMapper::entityToProjection).toList();
    }
}
