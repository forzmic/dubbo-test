package com.zm.duubo.consumer.dubboconsumer.rest;

import com.alibaba.fastjson.JSONObject;
import com.zm.dubbo.service.ItemApi;
import com.zm.dubbo.service.ItemResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Zhangmi
 * @create: 2019-04-24 17:08
 **/
@RestController
@RequestMapping("/rest")
@Slf4j
public class RestTest {

    @Autowired
    private ItemApi api;

    @GetMapping("/get")
    public String getRest(int num){
        if (num <= 0) {
            return "num is less zero, will get empty data";
        }
        ItemResp resp = api.getItemList(num);
        log.info("num={}, respNum={}", num, resp.getItems().size());
        return JSONObject.toJSONString(resp);
    }
}
