package org.kehl.entity;

import java.io.Serializable;

/**
 * (OrderTbl)实体类
 *
 * @author kehl
 * @since 2022-05-23 14:19:59
 */
public class OrderTbl implements Serializable {
    private static final long serialVersionUID = 683174299388924544L;

    private Integer id;

    private String userId;

    private String productId;

    private Integer totalAmount;

    private Double money;

    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderTbl{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", totalAmount=" + totalAmount +
                ", money=" + money +
                ", status=" + status +
                '}';
    }
}
