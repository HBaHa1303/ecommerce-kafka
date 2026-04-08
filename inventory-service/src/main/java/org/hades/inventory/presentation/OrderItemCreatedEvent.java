package org.hades.inventory.presentation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItemCreatedEvent {
    Long id;
    Long productId;
    Long price;
    Integer quantity;
}
