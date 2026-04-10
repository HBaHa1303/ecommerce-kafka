package org.hades.product.presentation;

import lombok.RequiredArgsConstructor;
import org.hades.product.application.ProductQueryHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductQueryHandler productQueryHandler;

    @GetMapping
    public List<ProductResponse> getProductsByIds (@RequestParam List<Long> ids) {
        return productQueryHandler.getProductsByIds(ids);
    }
}
