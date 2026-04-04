package org.hades.order.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItemCreatedEvent {
    Long id;
    Long productId;
    Long price;
    Integer quantity;
}
