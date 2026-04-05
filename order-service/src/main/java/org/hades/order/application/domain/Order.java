package org.hades.order.application.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    private Long id;
    private Long total;
    private List<OrderItem> orderItems;

    public static Order create(List<OrderItem> orderItems) {
        Long total = calculateTotal(orderItems);
        return new Order(null, total, orderItems);
    }

    private static Long calculateTotal(List<OrderItem> orderItems) {
        return orderItems.stream().mapToLong(oi -> oi.getPrice() * oi.getQuantity()).sum();
    }
}
