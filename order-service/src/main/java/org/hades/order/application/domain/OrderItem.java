package org.hades.order.application.domain;

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

    public static OrderItem create(Long productId, Long price, Integer quantity) {
        return new OrderItem(null, productId, price, quantity);
    }
}
