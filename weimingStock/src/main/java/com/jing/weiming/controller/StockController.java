package com.jing.weiming.controller;

import antlr.PythonCharFormatter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jing.weiming.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author jing
 * @create 2020-03-27-12:16
 */
@RestController
public class StockController {
    @Autowired
    private IStockService iStockService;

    @RequestMapping(value = "/getStockList")
    public Map<String, Object> getStockList(){
        Map<String, Object> map = iStockService.getStockList();
        return map;
    }
    @RequestMapping(value = "/getStockById/{sku_id}")
    public Map<String, Object> getStockById(@PathVariable("sku_id") String sku_id){
        Map<String, Object> map = iStockService.getStockById(sku_id);
        return map;
    }
    @RequestMapping(value = "/insertLimitPolicy/{json}")
    public Map<String, Object> insertLimitPolicy(@PathVariable("json") String json){
        Map<String, Object> policyInfo = JSONObject.parseObject(json, Map.class);
        return iStockService.insertLimitPolicy(policyInfo);
    }
}
