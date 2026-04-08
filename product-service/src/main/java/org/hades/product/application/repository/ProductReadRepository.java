package org.hades.product.application.repository;

import org.hades.product.application.projection.ProductProjection;
import org.hades.product.presentation.ProductResponse;

import java.util.List;

public interface ProductReadRepository {
    List<ProductProjection> getProductsByIds(List<Long> ids);
}
