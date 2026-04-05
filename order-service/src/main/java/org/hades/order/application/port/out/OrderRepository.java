package org.hades.order.application.port.out;

import org.hades.order.application.domain.Order;

public interface OrderRepository {
    void save(Order order);
}
