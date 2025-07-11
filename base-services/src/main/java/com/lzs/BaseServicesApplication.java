package com.lzs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author :liuzhensheng
 * @description :
 * @create :2023-12-02 17:40:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BaseServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseServicesApplication.class,args);
    }
}
