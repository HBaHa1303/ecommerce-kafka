package org.hades.product;

import org.hades.product.application.AProductMapper;
import org.hades.product.application.ProductQueryHandler;
import org.hades.product.application.repository.ProductReadRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductServiceConfiguration {

    @Bean
    public ProductQueryHandler getProductQueryHandler(ProductReadRepository repository, AProductMapper mapper) {
        return new ProductQueryHandler(repository, mapper);
    }
}
