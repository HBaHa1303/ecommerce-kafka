package org.hades.order.presentation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderRequest {
    private List<CreateOrderItemRequest> orderItems;
}
