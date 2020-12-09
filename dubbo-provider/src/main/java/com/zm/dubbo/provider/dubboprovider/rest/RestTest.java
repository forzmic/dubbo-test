package com.zm.dubbo.provider.dubboprovider.rest;

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
public class RestTest {

    @GetMapping("/get")
    public String getRest(String param){
        return "hello world " + param;
    }
}
