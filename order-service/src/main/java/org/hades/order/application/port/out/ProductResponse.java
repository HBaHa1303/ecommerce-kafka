package org.hades.order.application.port.out;

public record ProductResponse (
        Long id,
        String name,
        Long price
) {}