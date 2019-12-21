package com.lhz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @Auther: lhz
 * @Date: 2019/12/21 0021 11:10
 * @Description: 网关启动类
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class AppGateway {
    //@EnableZuulProxy 开启网关代理
    public static void main(String[] args) {
        SpringApplication.run(AppGateway.class, args);
    }
}
