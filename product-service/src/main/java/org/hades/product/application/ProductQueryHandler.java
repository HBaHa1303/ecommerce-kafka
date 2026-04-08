package org.hades.product.application;

import lombok.RequiredArgsConstructor;
import org.hades.product.application.repository.ProductReadRepository;
import org.hades.product.presentation.ProductResponse;

import java.util.List;

@RequiredArgsConstructor
public class ProductQueryHandler {
    private final ProductReadRepository repository;
    private final AProductMapper mapper;

    public List<ProductResponse> getProductsByIds(List<Long> ids) {
        return repository.getProductsByIds(ids).stream().map(mapper::projectionToResponse).toList();
    }
}
