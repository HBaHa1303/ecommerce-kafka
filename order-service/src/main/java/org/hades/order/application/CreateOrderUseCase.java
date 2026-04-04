package org.hades.order.application;

import lombok.AllArgsConstructor;
import org.hades.order.presentation.CreateOrderRequest;

@AllArgsConstructor
public class CreateOrderUseCase {
    private final EventBus eventBus;
    private final OrderRepository orderRepository;
    private final


    public void createOrder(CreateOrderRequest request) {

    }
}
