package org.kehl.dao;

import org.apache.ibatis.annotations.Mapper;
import org.kehl.entity.UserTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserTbl)表数据库访问层
 *
 * @author kehl
 * @since 2022-05-23 14:16:58
 */
@Mapper
public interface UserTblDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserTbl queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserTbl> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userTbl 实例对象
     * @return 对象列表
     */
    List<UserTbl> queryAll(UserTbl userTbl);

    /**
     * 新增数据
     *
     * @param userTbl 实例对象
     * @return 影响行数
     */
    int insert(UserTbl userTbl);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserTbl> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserTbl> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserTbl> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserTbl> entities);

    /**
     * 修改数据
     *
     * @param userTbl 实例对象
     * @return 影响行数
     */
    int update(UserTbl userTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

