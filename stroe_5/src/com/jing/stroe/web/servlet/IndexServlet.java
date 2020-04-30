package com.jing.stroe.web.servlet;

import com.jing.stroe.domain.Category;
import com.jing.stroe.domain.Product;
import com.jing.stroe.service.CategoryService;
import com.jing.stroe.service.ProductService;
import com.jing.stroe.service.ServiceImpl.CategoryServiceImpl;
import com.jing.stroe.service.ServiceImpl.ProductServiceImpl;
import com.jing.stroe.web.base.BaseServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@WebServlet(name = "IndexServlet")
public class IndexServlet extends BaseServlet {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        ProductService productService = new ProductServiceImpl();

        // 查询最新 最热商品
        List<Product> newProduct = productService.getNewProducts();
        List<Product> hotProduct = productService.getHotProducts();

        // 将两个结果返回到request
        req.setAttribute("news", newProduct);
        req.setAttribute("hots", hotProduct);

        // 最后返回真实的首页
        return "/jsp/index.jsp";
    }
}
