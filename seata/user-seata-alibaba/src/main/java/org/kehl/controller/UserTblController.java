package org.kehl.controller;

import org.checkerframework.checker.units.qual.C;
import org.kehl.api.OrderService;
import org.kehl.entity.CommonResult;
import org.kehl.entity.UserTbl;
import org.kehl.service.UserTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserTbl)表控制层
 *
 * @author kehl
 * @since 2022-05-23 12:14:57
 */
@RestController
@RequestMapping("user")
public class UserTblController {
    /**
     * 服务对象
     */
    @Resource
    private UserTblService userTblService;

    @Autowired
    private OrderService orderService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserTbl selectOne(Integer id) {
        return this.userTblService.queryById(id);
    }

    @RequestMapping("insert")
    public CommonResult insert(UserTbl user){
        return new CommonResult(userTblService.insert(user),"添加用户成功",200);
    }

    @RequestMapping("getAllOrderByUserId")
    public CommonResult getAllOrderByUserId(@RequestParam("userId") String userId){
        return new CommonResult(orderService.selectAllOrderByUserId(userId), String.format("查询用户%s所有的订单", userId),200);
    }
}
