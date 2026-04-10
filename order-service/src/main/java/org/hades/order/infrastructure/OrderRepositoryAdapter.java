package org.hades.order.infrastructure;

import lombok.AllArgsConstructor;
import org.hades.order.application.domain.Order;
import org.hades.order.application.port.out.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {
    private final OrderJpaRepository repository;
    private final IOrderMapper mapper;

    @Override
    public void save(Order order) {
        OrderEntity orderEntity = mapper.domainToEntity(order);
        repository.save(orderEntity);
    }
}
