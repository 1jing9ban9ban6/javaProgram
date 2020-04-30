package com.jing.weiming.controller;

import com.jing.weiming.serivce.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author jing
 * @create 2020-03-27-22:13
 */
@RestController
public class StorageController {
    @Autowired
    private IStorageService iStorageService;

    /**
     * 向表中插入库存
     * @param sku_id
     * @param inquanty
     * @param outquanty
     * @return
     */
    @RequestMapping(value = "/insertStorage/{sku_id}/{inquanty}/{outquanty}")
    public Map<String, Object> insertStorage(@PathVariable("sku_id") String sku_id,
                                             @PathVariable("inquanty") double inquanty,
                                             @PathVariable("outquanty") double outquanty){

        return iStorageService.insertStorage(sku_id, inquanty, outquanty);
    }
}
