package org.hades.inventory.presentation;

import lombok.RequiredArgsConstructor;
import org.hades.inventory.application.ReverseStockCommandHandler;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCreatedListener {
    private final ReverseStockCommandHandler reverseStockCommandHandler;

    @KafkaListener(topics = "order.events", groupId = "order-group")
    public void listen(OrderCreatedEvent event) {
        reverseStockCommandHandler.reverseStock(event);
    }
}
