package org.kehl.order.feign.Impl;

import org.kehl.order.feign.ProductFeignService;
import org.springframework.stereotype.Component;


@Component
public class ProductFeignServiceFallbackImpl implements ProductFeignService {
    @Override
    public String getProduct() {
        return "降级了";
    }
}
