package org.hades.order.application.port.out;

public interface EventBus {
    void publish(Object event);
}
