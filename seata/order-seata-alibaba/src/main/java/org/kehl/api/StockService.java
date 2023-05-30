package org.kehl.api;


import org.kehl.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "stock-seata-alibaba-service",path = "/stock")
public interface StockService {
    @RequestMapping("/reduce")
    public CommonResult reduce(@RequestParam(value = "productId") String productId, @RequestParam(value = "totalAmount") Integer totalAmount);
}
