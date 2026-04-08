package org.hades.product.application;

import org.hades.product.application.projection.ProductProjection;
import org.hades.product.presentation.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AProductMapper {
    ProductResponse projectionToResponse(ProductProjection projection);
}
