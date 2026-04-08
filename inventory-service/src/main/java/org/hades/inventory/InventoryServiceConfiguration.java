package org.hades.inventory;

import org.hades.inventory.application.InventoryRepository;
import org.hades.inventory.application.ReverseStockCommandHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryServiceConfiguration {
    @Bean
    public ReverseStockCommandHandler reverseStockCommandHandler(InventoryRepository inventoryRepository) {
        return new ReverseStockCommandHandler(inventoryRepository);
    }
}
