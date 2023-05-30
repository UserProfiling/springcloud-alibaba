package org.kehl.controller;

import org.kehl.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.kehl.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/add")
    public String add(){
        Order order =new Order();
        order.setProductId("9");
        order.setStatus(0);
        order.setTotalAmount(100);
        orderService.createOrder(order);
        return "下单成功";
    }

}
