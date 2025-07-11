package com.lzs.ext.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author :liuzhensheng
 * @description :
 * @create :2023-12-10 22:47:00
 */
@FeignClient(url = "http://localhost:8001/base-services",name = "base-services")
public interface BaseServicesApi {

    @PostMapping(value = "/base/test/testLog")
    public JSONObject testLog();
}
