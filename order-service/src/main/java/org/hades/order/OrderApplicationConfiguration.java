package org.hades.order;

import org.apache.kafka.clients.admin.NewTopic;
import org.hades.order.application.EventBus;
import org.hades.order.application.OrderRepository;
import org.hades.order.application.CreateOrderUseCase;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients
@Configuration
public class OrderApplicationConfiguration {
    @Bean
    public CreateOrderUseCase orderUseCase(EventBus eventBus, OrderRepository orderRepository) {
        return new CreateOrderUseCase(eventBus, orderRepository);
    }

    @Bean
    public NewTopic orderEvents () {
        return new NewTopic("order.events", 1, (short) 1);
    }
}
