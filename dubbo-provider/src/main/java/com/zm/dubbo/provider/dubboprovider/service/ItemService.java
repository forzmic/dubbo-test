package com.zm.dubbo.provider.dubboprovider.service;

import com.google.common.collect.Lists;
import com.zm.dubbo.service.Item;
import com.zm.dubbo.service.ItemApi;
import com.zm.dubbo.service.ItemResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @description:
 * @create: 2020-12-08 21:38
 **/
@Service
@Slf4j
public class ItemService implements ItemApi {

    @Override
    public ItemResp getItemList(int itemNum) {
        List<Item> items = Lists.newArrayList();
        for (int i = 0; i < itemNum; i++) {
            items.add(Item.builder()
                    .id(RandomUtils.nextInt(100000, 1000000))
                    .userId(RandomUtils.nextInt(100000, 1000000))
                    .score(RandomUtils.nextFloat(0, 1))
                    .sourceType(RandomUtils.nextInt(0, 1))
                    .build());
        }
        log.info("itemNum={}, resultNum={}", itemNum, items.size());
        return ItemResp.builder().items(items).build();
    }
}
