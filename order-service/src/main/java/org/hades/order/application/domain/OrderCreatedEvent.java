package org.hades.order.application.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCreatedEvent implements DomainEvent{
    private Long id;
    private Long total;
    private List<OrderItemCreatedEvent> orderItems;

    public static OrderCreatedEvent from (Order order) {
        List<OrderItemCreatedEvent> orderItems = order.getOrderItems()
                .stream()
                .map(OrderItemCreatedEvent::from)
                .toList();
        return new OrderCreatedEvent(order.getId(), order.getTotal(), orderItems);
    }
}
