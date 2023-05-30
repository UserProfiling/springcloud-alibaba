package org.kehl.entity;

import java.io.Serializable;

/**
 * (StockTbl)实体类
 *
 * @author kehl
 * @since 2022-05-23 14:19:21
 */
public class StockTbl implements Serializable {
    private static final long serialVersionUID = 135224824858003513L;

    private Integer id;

    private String productId;

    private Integer count;

    private String productName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
