package com.example.shop.demo.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.app.models.AlipayTradeAppPayResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.example.shop.demo.entity.PaymentBo;
import com.example.shop.demo.util.OrderUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PayService {

    @Value("${alipay.returnUrl}")
    private String returnUrl;

    /**
     * 下单支付
     *
     * @author :Damon Wang
     * @Date : 2021-05-26
     */
    public Object pay(PaymentBo bo) throws Exception {

        // //从存储介质(如MySQL、Redis)查询商品信息、总金额等敏感信息
        /*

         */

        System.out.println("------->" + bo.getSubject());
        System.out.println("------->" + bo.getTotal());
        // 调用支付宝SDk，发起支付
        /**
         * 网页支付模式
         * AlipayTradePagePayResponse response = Factory.Payment.Page().pay(bo.getSubject(), OrderUtil.getOrderNo(),bo.getTotal().toString(),returnUrl);
         */

        /**
         * 手机支付模式
         */
        AlipayTradeAppPayResponse response = Factory.Payment.App().pay(bo.getSubject(), OrderUtil.getOrderNo(), bo.getTotal());


        return response.body;
    }

}
