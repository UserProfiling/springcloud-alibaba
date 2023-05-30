package org.kehl.dao;

import org.apache.ibatis.annotations.Mapper;
import org.kehl.entity.StockTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (StockTbl)表数据库访问层
 *
 * @author kehl
 * @since 2022-05-23 14:19:21
 */
@Mapper
public interface StockTblDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockTbl queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<StockTbl> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param stockTbl 实例对象
     * @return 对象列表
     */
    List<StockTbl> queryAll(StockTbl stockTbl);

    /**
     * 新增数据
     *
     * @param stockTbl 实例对象
     * @return 影响行数
     */
    int insert(StockTbl stockTbl);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockTbl> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StockTbl> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockTbl> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<StockTbl> entities);

    /**
     * 修改数据
     *
     * @param stockTbl 实例对象
     * @return 影响行数
     */
    int update(StockTbl stockTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int reduce(@Param("productId") String productId,@Param("totalAmount") Integer totalAmount);

    StockTbl selectByProductId(@Param("productId") String productId);
}

