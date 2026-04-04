package org.hades.order.presentation;

import lombok.AllArgsConstructor;
import org.hades.order.application.CreateOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createOrder (CreateOrderRequest request) {
        createOrderUseCase.createOrder(request);
    }
}
