package com.lzs.ext.controller;

import com.alibaba.fastjson.JSONObject;
import com.lzs.ext.api.BaseServicesApi;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :liuzhensheng
 * @description :
 * @create :2023-12-10 22:46:00
 */
@Slf4j
@RestController
@RequestMapping(value = "/base/test")
public class BaseTestController {

    public static final Logger logger = LoggerFactory.getLogger("secure-access");

    @Autowired
    private BaseServicesApi baseServicesApi;

    @GetMapping(value = "/feignTest")
    public JSONObject feignTest(){
        JSONObject jsonObject = baseServicesApi.testLog();
        log.info("sdjsjj");
        return jsonObject;
    }

    public static void main(String[] args) {
        logger.info("sdjsjj");
        log.error("sssss");
    }
}
