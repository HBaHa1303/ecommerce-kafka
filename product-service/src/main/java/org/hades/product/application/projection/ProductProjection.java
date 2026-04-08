package org.hades.product.application.projection;

public record ProductProjection (
        Long id,
        String name,
        Long price
) {}
