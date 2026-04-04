package org.hades.order.infrastructure;

import lombok.AllArgsConstructor;
import org.hades.order.application.ProductClient;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductClientAdapter implements ProductClient {
    private final ProductFeignClient productFeignClient;

}
