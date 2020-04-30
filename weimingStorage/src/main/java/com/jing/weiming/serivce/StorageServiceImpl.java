package com.jing.weiming.serivce;

import com.jing.weiming.dao.IStorageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jing
 * @create 2020-03-27-22:13
 */
@Service
public class StorageServiceImpl implements IStorageService{
    @Autowired
    private IStorageDao iStorageDao;
    @Override
    public Map<String, Object> insertStorage(String sku_id, double in_quanty, double out_quanty) {
        Map<String, Object> resultMap = new HashMap<>();
//        判断传入的id是否为空
        if (sku_id==null||"".equals(sku_id)){
            resultMap.put("result", false);
            resultMap.put("msg", "传入的商品不能为空");
            return resultMap;
        }
//        判断入库商品和出库商品不能同时为0
        if (in_quanty==0&&out_quanty==0){
            resultMap.put("result", false);
            resultMap.put("msg", "入库和出库商品不能同时为零");
            return resultMap;
        }
//        入库操作
        resultMap = iStorageDao.insertStorage(sku_id, in_quanty, out_quanty);
        return resultMap;
    }
}
