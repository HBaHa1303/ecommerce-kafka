package org.hades.order.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderCreatedEvent {
    private Long id;
    private Long total;
    private OrderItemCreatedEvent orderItems;
}
