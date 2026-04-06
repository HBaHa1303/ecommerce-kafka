package org.hades.product.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @GetMapping
    public List<ProductResponse> getProductByIds (List<Long> ids) {

    }
}
