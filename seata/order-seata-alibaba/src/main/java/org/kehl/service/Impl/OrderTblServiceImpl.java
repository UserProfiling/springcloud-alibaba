package org.kehl.service.Impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.checkerframework.checker.units.qual.A;
import org.kehl.api.StockService;
import org.kehl.entity.OrderTbl;
import org.kehl.dao.OrderTblDao;
import org.kehl.service.OrderTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderTbl)表服务实现类
 *
 * @author kehl
 * @since 2022-05-23 14:20:00
 */
@Service("orderTblService")
public class OrderTblServiceImpl implements OrderTblService {
    @Autowired
    private OrderTblDao orderTblDao;

    @Autowired
    private StockService stockService;


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderTbl> queryAllByLimit(int offset, int limit) {
        return this.orderTblDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    @Override
    @GlobalTransactional
    public OrderTbl insert(OrderTbl orderTbl) {
        this.orderTblDao.insert(orderTbl);
        this.stockService.reduce(orderTbl.getProductId(),orderTbl.getTotalAmount());
        return orderTbl;
    }

    /**
     * 修改数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    @Override
    public OrderTbl update(OrderTbl orderTbl) {
        this.orderTblDao.update(orderTbl);
        return this.queryById(orderTbl.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderTblDao.deleteById(id) > 0;
    }

    @Override
    @Trace
    @Tag(key="all",value="returnedObj")
    public List<OrderTbl> queryAll() {
        return this.orderTblDao.queryAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Trace
    @Tags({@Tag( key="Order",value="returnedObj"),
            @Tag(key="param",value="arg[0]"),
    })
    public OrderTbl queryById(Integer id) {
        return this.orderTblDao.queryById(id);
    }


    @Override
    public List<OrderTbl> selectAllOrderByUserId(String userId) {
        return this.orderTblDao.selectAllOrderByUserId(userId);
    }
}
