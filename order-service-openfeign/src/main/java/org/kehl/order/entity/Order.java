package org.kehl.order.entity;

import lombok.Data;


@Data
public class Order {
    /**
     * //订单id
     */
    private String oid;

    /**
     * //用户
     */

    private String uid;
    /**
     * 用户名
     */
    private String username;

    //商品
    private String pid;//商品id
    private String pname;//商品名称
    private Double pprice;//商品单价

    //数量
    private Integer number;//购买数量

}
