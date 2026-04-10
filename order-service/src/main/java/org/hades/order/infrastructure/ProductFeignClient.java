package org.hades.order.infrastructure;

import org.hades.order.application.port.out.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "localhost:9001/api/v1/products", name = "product-service")
public interface ProductFeignClient {
    @GetMapping
    List<ProductResponse> getProductsByIds(@RequestParam List<Long> ids);
}
