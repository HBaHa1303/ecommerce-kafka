package org.hades.order.application;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    private Long id;
    private Long total;
    private OrderItemCreatedEvent orderItems;

    public static Order create(Long id, Long total, OrderItemCreatedEvent orderItems) {
        return new Order(id, total, orderItems);
    }
}
