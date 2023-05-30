package org.kehl.service.Impl;

import org.kehl.entity.UserTbl;
import org.kehl.dao.UserTblDao;
import org.kehl.service.UserTblService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserTbl)表服务实现类
 *
 * @author kehl
 * @since 2022-05-23 14:17:05
 */
@Service("userTblService")
public class UserTblServiceImpl implements UserTblService {
    @Resource
    private UserTblDao userTblDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserTbl queryById(Integer id) {
        return this.userTblDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserTbl> queryAllByLimit(int offset, int limit) {
        return this.userTblDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userTbl 实例对象
     * @return 实例对象
     */
    @Override
    public UserTbl insert(UserTbl userTbl) {
        this.userTblDao.insert(userTbl);
        return userTbl;
    }

    /**
     * 修改数据
     *
     * @param userTbl 实例对象
     * @return 实例对象
     */
    @Override
    public UserTbl update(UserTbl userTbl) {
        this.userTblDao.update(userTbl);
        return this.queryById(userTbl.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userTblDao.deleteById(id) > 0;
    }
}
