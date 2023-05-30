package org.kehl.api;

import org.kehl.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * springcloud-alibaba
 *
 * @author : kehl
 * @date : 2022-05-23 12:17
 **/
@FeignClient(value = "order-seata-alibaba-service",path = "/order")
public interface OrderService {
    @RequestMapping("/selectAllOrderByUserId")
    public List<Order> selectAllOrderByUserId(@RequestParam(value = "userId") String userId);
}
