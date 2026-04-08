package org.hades.order.infrastructure;

import lombok.AllArgsConstructor;
import org.hades.order.application.KafkaTopic;
import org.hades.order.application.port.out.EventBus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaEventBus implements EventBus {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Override
    public void publish(Object event) {
        KafkaTopic annotation = event.getClass().getAnnotation(KafkaTopic.class);
        if (annotation == null) {
            throw new IllegalArgumentException(
                    "Event " + event.getClass().getSimpleName() + " missing @KafkaTopic annotation"
            );
        }
        kafkaTemplate.send(annotation.value(), event);
    }
}
