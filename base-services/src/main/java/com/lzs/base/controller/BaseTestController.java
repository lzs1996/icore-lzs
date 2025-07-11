package com.lzs.base.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :liuzhensheng
 * @description :
 * @create :2023-12-02 16:59:00
 */
@Slf4j
@RestController
@RequestMapping(value = "/base/test")
public class BaseTestController {

    @PostMapping(value = "/testLog")
    public JSONObject testLog(){
        String phone = "18074649711";
        String cardNo = "431121199604250537";
        log.info("phone: {}",phone);
        log.info("cardNo: {}", cardNo);
        JSONObject result = new JSONObject();
        result.put("phone",phone);
        result.put("cardNo",cardNo);
        return result;
    }
}
