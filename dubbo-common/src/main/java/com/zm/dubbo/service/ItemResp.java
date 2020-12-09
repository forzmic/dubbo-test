package com.zm.dubbo.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Zhangmi
 * @create: 2020-10-20 11:33
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResp implements Serializable {
    private static final long serialVersionUID = 2716826949515438425L;
    private List<Item> items;
    private Map<String, String> extFields;
    private Map<String, Object> extObjects;
}
