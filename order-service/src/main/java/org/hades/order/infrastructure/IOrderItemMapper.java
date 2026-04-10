package org.hades.order.infrastructure;

import org.hades.order.application.domain.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrderItemMapper {
    OrderItemEntity domainToEntity (OrderItem orderItem);
}
