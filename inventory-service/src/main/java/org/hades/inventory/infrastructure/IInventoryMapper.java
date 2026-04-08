package org.hades.inventory.infrastructure;

import org.hades.inventory.application.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IInventoryMapper {
    InventoryEntity domainToEntity(Inventory inventory);
}
