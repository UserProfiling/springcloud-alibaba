package org.kehl.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.kehl.entity.StockTbl;
import org.kehl.dao.StockTblDao;
import org.kehl.service.StockTblService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (StockTbl)表服务实现类
 *
 * @author kehl
 * @since 2022-05-23 14:19:23
 */
@Service("stockTblService")
@Slf4j
public class StockTblServiceImpl implements StockTblService {
    @Resource
    private StockTblDao stockTblDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockTbl queryById(Integer id) {
        return this.stockTblDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<StockTbl> queryAllByLimit(int offset, int limit) {
        return this.stockTblDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param stockTbl 实例对象
     * @return 实例对象
     */
    @Override
    public StockTbl insert(StockTbl stockTbl) {
        this.stockTblDao.insert(stockTbl);
        return stockTbl;
    }

    /**
     * 修改数据
     *
     * @param stockTbl 实例对象
     * @return 实例对象
     */
    @Override
    public StockTbl update(StockTbl stockTbl) {
        this.stockTblDao.update(stockTbl);
        return this.queryById(stockTbl.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.stockTblDao.deleteById(id) > 0;
    }

    @Override
    public int reduce(String productId, Integer totalAmount) {
        System.out.println("更新商品"+productId);
        StockTbl stock=stockTblDao.selectByProductId(productId);
        if (stock==null){
            log.error("查询不到",productId);
            return 0;
        }
        //库存不足
        if (stock.getCount()<totalAmount){
            //删除失败
            log.error("库存不足");
            return 0;
        }
        return stockTblDao.reduce(productId,totalAmount);
    }
}
