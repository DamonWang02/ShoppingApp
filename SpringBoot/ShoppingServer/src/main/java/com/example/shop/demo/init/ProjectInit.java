package com.example.shop.demo.init;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 用于初始化，配置相应参数；
 *
 * @author :Damon Wang
 * @Date : 2021-05-26
 */
@Component
public class ProjectInit implements ApplicationRunner {

    @Value("${alipay.appId}")
    private String appId;

    @Value("${alipay.privateKey}")
    private String privateKey;

    @Value("${alipay.publicKey}")
    private String publicKey;

    @Value("${alipay.gateway}")
    private String gateway;

    @Value("${alipay.notifyUrl}")
    private String notifyUrl;

    /**
     * 项目初始化事件
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //初始化支付宝SDK
        Factory.setOptions(getOptions());
        System.out.println("**********支付宝SDK初始化完成**********");
    }

    private Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = this.gateway;
        config.signType = "RSA2";

        config.appId = this.appId;

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = this.privateKey;


        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = this.publicKey;

        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = this.notifyUrl;

        return config;
    }


}