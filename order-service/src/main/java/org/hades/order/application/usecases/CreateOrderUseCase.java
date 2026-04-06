package org.hades.order.application.usecases;

import lombok.AllArgsConstructor;
import org.hades.order.application.domain.Order;
import org.hades.order.application.domain.OrderCreatedEvent;
import org.hades.order.application.domain.OrderItem;
import org.hades.order.application.domain.OrderItemCreatedEvent;
import org.hades.order.application.exceptions.NotFoundException;
import org.hades.order.application.port.out.EventBus;
import org.hades.order.application.port.out.ProductClient;
import org.hades.order.application.port.out.ProductResponse;
import org.hades.order.application.port.out.OrderRepository;
import org.hades.order.presentation.CreateOrderRequest;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CreateOrderUseCase {
    private final EventBus eventBus;
    private final OrderRepository orderRepository;
    private final ProductClient productClient;


    public void createOrder(CreateOrderRequest request) {
        List<ProductResponse> response = productClient.findAllByIds(
                request.getOrderItems().stream().map(OrderItemCreatedEvent::getProductId
        ).toList());

        Map<Long, Long> mapProduct = request.getOrderItems().stream().map(oi ->
                        response.stream()
                                .filter(p -> p.id().equals(oi.getId()))
                                .findFirst()
                                .orElseThrow(() -> new NotFoundException("Product id " + oi.getProductId() + " is not exists")))
                .collect(Collectors.toMap(ProductResponse::id, ProductResponse::price));

        List<OrderItem> orderItems = request.getOrderItems()
                .stream()
                .map(oi ->
                        OrderItem.create(
                                oi.getProductId(),
                                mapProduct.get(oi.getId()),
                                oi.getQuantity())).toList();
        Order order = Order.create(orderItems);
        orderRepository.save(order);

        order.pullEvents().forEach(eventBus::publish);
    }
}
