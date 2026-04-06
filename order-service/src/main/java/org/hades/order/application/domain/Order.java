package org.hades.order.application.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Order {
    private final Long id;
    private final Long total;
    private final List<OrderItem> orderItems;
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    public Order(Long id, Long total, List<OrderItem> orderItems) {
        this.id = id;
        this.total = total;
        this.orderItems = orderItems;
    }

    public static Order create(List<OrderItem> orderItems) {
        Long total = calculateTotal(orderItems);
        Order order = new Order(null, total, orderItems);

        order.domainEvents.add(OrderCreatedEvent.from(order));
        return order;
    }

    private static Long calculateTotal(List<OrderItem> orderItems) {
        return orderItems.stream().mapToLong(oi -> oi.getPrice() * oi.getQuantity()).sum();
    }

    public List<DomainEvent> pullEvents () {
        List<DomainEvent> copy = List.copyOf(domainEvents);
        domainEvents.clear();
        return copy;
    }
}
