package org.hades.order.application;

public interface EventBus {
    void publish(Object event);
}
