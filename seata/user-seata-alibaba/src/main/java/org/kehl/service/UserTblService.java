package org.kehl.service;

import org.kehl.entity.UserTbl;

import java.util.List;

/**
 * (UserTbl)表服务接口
 *
 * @author kehl
 * @since 2022-05-23 12:14:56
 */
public interface UserTblService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserTbl queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserTbl> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userTbl 实例对象
     * @return 实例对象
     */
    UserTbl insert(UserTbl userTbl);

    /**
     * 修改数据
     *
     * @param userTbl 实例对象
     * @return 实例对象
     */
    UserTbl update(UserTbl userTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
