package org.hades.inventory.presentation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCreatedEvent {
    private Long id;
    private Long total;
    private List<OrderItemCreatedEvent> orderItems;
}
