package com.xmu.istudy;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chaney
 */


@SpringCloudApplication
@EnableDiscoveryClient
@RestController
public class NacosTestApplication {
    public static void main(String[] args){
        SpringApplication.run(NacosTestApplication.class, args);
    }

    class EchoController {
        @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string;
        }
    }

    @Value("${common.name}")
    private String config;

    @GetMapping("/config")
    public String getConfig() {
        System.out.println(config);
        return config;
    }
}


