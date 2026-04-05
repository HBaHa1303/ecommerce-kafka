package org.hades.order.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderCreatedEvent {
    private Long id;
    private Long total;
    private List<OrderItemCreatedEvent> orderItems;

    public OrderCreatedEvent(Order order) {
        this.id = order.getId();
        this.total = order.getTotal();
        this.orderItems = order.getOrderItems()
                .stream()
                .map(oi -> new OrderItemCreatedEvent(
                        oi.getId(),
                        oi.getProductId(),
                        oi.getPrice(),
                        oi.getQuantity()))
                .toList();
    }
}
