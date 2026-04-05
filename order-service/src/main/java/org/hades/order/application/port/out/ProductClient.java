package org.hades.order.application.port.out;

import java.util.List;

public interface ProductClient {

    List<ProductResponse> findAllByIds(List<Long> list);
}
