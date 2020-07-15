package com.xmu.istudy;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringCloudApplication
@EnableDiscoveryClient
public class IStudyReservationApplication {
    public static void main(String[] args) {
        SpringApplication.run(IStudyReservationApplication.class, args);
    }
}
