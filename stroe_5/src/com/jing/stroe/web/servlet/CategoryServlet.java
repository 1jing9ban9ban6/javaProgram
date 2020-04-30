package com.jing.stroe.web.servlet;

import com.jing.stroe.domain.Category;
import com.jing.stroe.service.CategoryService;
import com.jing.stroe.service.ServiceImpl.CategoryServiceImpl;
import com.jing.stroe.utils.JedisUtils;
import com.jing.stroe.web.base.BaseServlet;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;
import sun.misc.Request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "CategoryServlet")
public class CategoryServlet extends BaseServlet {

    public String findAllCats(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        // 在redis中获取缓存到的分类
        Jedis jedis = JedisUtils.getJedis();
        String allCats = jedis.get("allCats");
        if(allCats==null || "".equals(allCats)){
            //查询全部分类
            CategoryService CategoryService=new CategoryServiceImpl();
            List<Category> list=CategoryService.findAllCats();
            // 转为json格式  并告诉浏览器响应回去的数据是json
            allCats = JSONArray.fromObject(list).toString();
            resp.setContentType("application/json;charset=utf-8");
            // 放到redis中去
            jedis.set("allCats", allCats);
            // 做出响应
            resp.getWriter().print(allCats);
        }else {
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().print(allCats);
        }
        return null;
    }
}
