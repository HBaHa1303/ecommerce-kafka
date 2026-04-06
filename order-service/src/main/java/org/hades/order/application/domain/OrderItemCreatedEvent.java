package org.hades.order.application.domain;

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

    public static OrderItemCreatedEvent from (OrderItem orderItem) {
        return new OrderItemCreatedEvent(orderItem.id, orderItem.productId, orderItem.price, orderItem.quantity);
    }
}
