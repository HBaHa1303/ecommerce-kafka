package org.hades.order.infrastructure;

import org.hades.order.application.domain.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrderMapper {
    OrderEntity domainToEntity(Order order);
}
