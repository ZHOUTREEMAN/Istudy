package com.xmu.istudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xmu.istudy.service")
@ComponentScan("com.xmu.istudy.service")
@MapperScan("com.xmu.istudy.dao")
public class IStudyReservationApplication {
    public static void main(String[] args) {
        SpringApplication.run(IStudyReservationApplication.class, args);
    }
}
