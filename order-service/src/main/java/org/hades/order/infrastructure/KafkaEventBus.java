package org.hades.order.infrastructure;

import lombok.AllArgsConstructor;
import org.hades.order.application.EventBus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaEventBus implements EventBus {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Override
    public void publish(Object event) {
        String topic = event.getClass().getSimpleName();
        kafkaTemplate.send(topic, event);
    }
}
