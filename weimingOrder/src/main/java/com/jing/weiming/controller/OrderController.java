package com.jing.weiming.controller;

import com.alibaba.fastjson.JSONObject;
import com.jing.weiming.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @RequestMapping(value = "/createOrder/{sku_id}")
    public Map<String, Object> createOrder(@PathVariable("sku_id") String sku_id,
                                           HttpServletRequest httpServletRequest){
//        HttpSession httpSession = httpServletRequest.getSession();
//        Object o = httpSession.getAttribute("user");
//        Map<String, Object> userMap = JSONObject.parseObject(o.toString(), Map.class);
        return iOrderService.createOrder(sku_id, "31"); //userMap.get("user_id").toString()
    }

    @RequestMapping(value = "/getOrder/{order_id}")
    public Map<String, Object> getOrder(@PathVariable("order_id") String order_id){
        return iOrderService.getOrder(order_id);
    }


    @RequestMapping(value = "/payOrder/{order_id}")
    public Map<String, Object> payOrder(@PathVariable("order_id") String order_id){
        //模拟支付已经返回正常数据
        boolean isPay = true;
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (!isPay){
            resultMap.put("result", false);
            resultMap.put("msg", "支付接口调用失败！");
            return resultMap;
        }
        Map<String, Object> order = iOrderService.getOrder(order_id);
        Object id = order.get("sku_id");
        String sku_id = id.toString();
        return iOrderService.payOrder(order_id, sku_id);
    }

    @RequestMapping(value = "/ms/{sku_id}")
    public Map<String, Object> ms(@PathVariable("sku_id") String sku_id){
        return iOrderService.ms(sku_id);
    }
}
