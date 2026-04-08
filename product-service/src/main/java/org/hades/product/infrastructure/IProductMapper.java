package org.hades.product.infrastructure;

import org.hades.product.application.projection.ProductProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    ProductProjection entityToProjection(ProductEntity productEntity);
}
