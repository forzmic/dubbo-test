package com.zm.dubbo.service;

public interface ItemApi {
    /**
     * 获取批量Item
     * @param itemNum 请求参数
     * @return
     */
    ItemResp getItemList(int itemNum);
}
