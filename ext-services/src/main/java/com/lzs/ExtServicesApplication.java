package com.lzs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :liuzhensheng
 * @description :
 * @create :2023-12-02 17:40:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.lzs.ext.api"})
@ComponentScan(basePackages = {"com.lzs.*"})
public class ExtServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExtServicesApplication.class,args);
    }
}
