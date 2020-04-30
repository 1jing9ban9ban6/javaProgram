package com.jing.stroe.web.servlet;

import com.jing.stroe.domain.PageModel;
import com.jing.stroe.domain.Product;
import com.jing.stroe.service.ProductService;
import com.jing.stroe.service.ServiceImpl.ProductServiceImpl;
import com.jing.stroe.web.base.BaseServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductServlet")
public class ProductServlet extends BaseServlet {
    /**
     * 根据id查找一件商品 用于展示商品详情
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String getProductById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pid = request.getParameter("pid");
        ProductService productService = new ProductServiceImpl();
        Product p = productService.getProductById(pid);
        request.setAttribute("product", p);
        return "/jsp/product_info.jsp";
    }

    /**
     * 根据id查找商品 用于分页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findProductsWithCidAndPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 接收当前页码 转成整型
        String num = request.getParameter("num");
        int curNum = Integer.parseInt(num);
        // 接收分类cid 可以查找该分类下的全部商品 并且实现分页
        String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        ProductService productService = new ProductServiceImpl();
        PageModel pm=productService.findProductsWithCidAndPage(cid,curNum);
        //将PageModel对象存入到request
        request.setAttribute("page", pm);
        request.setAttribute("cname", cname);
        //转发到"/jsp/product_list.jsp"
        return "/jsp/product_list.jsp";
    }

}
