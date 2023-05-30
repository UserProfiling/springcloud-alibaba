package org.kehl.service;

import org.kehl.entity.OrderTbl;

import java.util.List;

/**
 * (OrderTbl)表服务接口
 *
 * @author kehl
 * @since 2022-05-23 14:20:00
 */
public interface OrderTblService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderTbl queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<OrderTbl> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    OrderTbl insert(OrderTbl orderTbl);

    /**
     * 修改数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    OrderTbl update(OrderTbl orderTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<OrderTbl> queryAll();

    List<OrderTbl> selectAllOrderByUserId(String userId);
}
