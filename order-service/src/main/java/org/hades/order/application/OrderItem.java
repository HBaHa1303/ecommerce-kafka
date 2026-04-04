package org.hades.order.application;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItem {
    Long id;
    Long productId;
    Long price;
    Integer quantity;

    public static OrderItem create(Long id, Long productId, Long price, Integer quantity) {
        return new OrderItem(id, productId, price, quantity);
    }
}
