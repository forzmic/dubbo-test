package com.zm.dubbo.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @description:
 * @author: ZM
 * @create: 2020-10-19 15:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item implements Serializable {
    private long userId;
    private long id;
    private double score;
    private int sourceType;
    private Map<String, String> extFields;
    private Map<String, Object> extObjects;
}
