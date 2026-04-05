package org.hades.order.infrastructure;

import lombok.AllArgsConstructor;
import org.hades.order.application.port.out.ProductClient;
import org.hades.order.application.port.out.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductClientAdapter implements ProductClient {
    private final ProductFeignClient productFeignClient;

    @Override
    public List<ProductResponse> findAllByIds(List<Long> list) {
        return List.of();
    }
}
