package com.example.shop.demo.controller;


import com.example.shop.demo.entity.PaymentBo;
import com.example.shop.demo.service.impl.PayService;
import lombok.AllArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 支付相关的控制器
 *
 * @author :Damon Wang
 * @Date : 2021-05-26
 */

@RestController
@RequestMapping(value = "/pay")
@AllArgsConstructor
public class PayController {


    private PayService payService;

    /**
     * 开启下单
     *
     */

    @PostMapping(value = "/confirm")
    public Object payWithPost(PaymentBo bo) throws Exception {


        return payService.pay(bo);
    }


    /**
     * 支付完成时，服务端返回的参数。
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/fallback")
    public Object notifyAsync(HttpServletRequest request) {
        Map map = request.getParameterMap();
        System.out.println("--------------->支付完成时，服务端返回的参数" + map.toString());
        System.out.println(map.toString());
        String body = (String) map.get("body");
        String out_trade_no = (String) map.get("out_trade_no");
        String total_amount = (String) map.get("total_amount");
        String time_stamp = (String) map.get("time_stamp");
        System.out.println("---------->" + body);
        System.out.println("------------>" + time_stamp);

        return "Ok";
    }


}
