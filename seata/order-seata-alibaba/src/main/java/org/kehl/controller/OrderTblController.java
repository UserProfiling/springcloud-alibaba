package org.kehl.controller;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.checkerframework.checker.units.qual.C;
import org.kehl.entity.CommonResult;
import org.kehl.entity.OrderTbl;
import org.kehl.service.OrderTblService;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("order")
@Slf4j
public class OrderTblController {
    /**
     * 服务对象
     */
    @Resource
    private OrderTblService orderTblService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrderTbl selectOne(Integer id) {
        return this.orderTblService.queryById(id);
    }


    @RequestMapping("/insert")
    public CommonResult add(OrderTbl order){
        log.info("Receive new Order ",order);
        return new CommonResult(orderTblService.insert(order),"订单创建成功",200);

    }

    @RequestMapping("all")
    public CommonResult all() throws InterruptedException {
        return new CommonResult(orderTblService.queryAll(),"获取所有订单",200);
    }

    @RequestMapping("getById/{id}")
    public CommonResult getById(@PathVariable("id") Integer id){
        return new CommonResult(orderTblService.queryById(id), String.format("查询%d订单成功", id),200);
    }

    @RequestMapping("/selectAllOrderByUserId")
    public List<OrderTbl> selectAllOrderByUserId(@RequestParam(value = "userId") String userId){
        return orderTblService.selectAllOrderByUserId(userId);
    }


}
