package org.hades.order.infrastructure;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "localhost:8080")
public interface ProductFeignClient {
}
