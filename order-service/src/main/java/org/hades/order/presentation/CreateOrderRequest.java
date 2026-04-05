package org.hades.order.presentation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hades.order.application.domain.OrderItemCreatedEvent;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateOrderRequest {
    private Long id;
    private Long total;
    private List<OrderItemCreatedEvent> orderItems;
}
