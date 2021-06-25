package com.example.shop.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 发起支付时，相应的参数；
 *
 * @author :Damon Wang
 * @Date : 2021-05-26
 */
@Data
public class PaymentBo {
    // 商品Id，商品数量，商品名称，商品价格,总金额等等；

    // 商品名称
    private String subject;

    // 总金额
    private String total;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
