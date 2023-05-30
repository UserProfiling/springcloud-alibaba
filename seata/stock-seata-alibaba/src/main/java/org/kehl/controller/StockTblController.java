package org.kehl.controller;

import lombok.extern.slf4j.Slf4j;
import org.kehl.entity.StockTbl;
import org.kehl.entity.CommonResult;
import org.kehl.service.StockTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (StockTbl)表控制层
 *
 * @author kehl
 * @since 2022-05-23 14:19:23
 */
@RestController
@RequestMapping("stock")
@Slf4j
public class StockTblController {
    /**
     * 服务对象
     */
    @Autowired
    private StockTblService stockTblService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public StockTbl selectOne(Integer id) {
        return this.stockTblService.queryById(id);
    }



    @RequestMapping("/add")
    public CommonResult add(StockTbl stock){
        return new CommonResult(stockTblService.insert(stock),"库存添加成功",200);
    }


    @RequestMapping("/reduce")
    public CommonResult reduce(@RequestParam(value = "productId") String productId,@RequestParam(value="totalAmount") Integer totalAmount){
        int result= stockTblService.reduce(productId,totalAmount);
        if (result>0){
            return new CommonResult(productId,"扣减库存成功",200);
        }else{
            log.error("扣减库存失败，库存不足");
        }
        return new CommonResult(productId,"扣减库存失败",500);
    }
    
}
