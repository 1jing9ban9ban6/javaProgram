package com.jing.stroe.web.servlet;

import com.jing.stroe.domain.Cart;
import com.jing.stroe.domain.Category;
import com.jing.stroe.service.CategoryService;
import com.jing.stroe.service.ServiceImpl.CategoryServiceImpl;
import com.jing.stroe.utils.UUIDUtils;
import com.jing.stroe.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@WebServlet(name = "AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet {
    public String findAllCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> allCats = categoryService.findAllCats();
        request.setAttribute("allCats", allCats);
        return "/admin/category/list.jsp";
    }
    public String addCategoryUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/admin/category/add.jsp";
    }
    public String addCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cname = request.getParameter("cname");
        String cid = UUIDUtils.getId();
        Category category = new Category();
        category.setCid(cid);
        category.setCname(cname);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.addCategory(category);
        response.sendRedirect("/store_5/AdminCategoryServlet?method=findAllCategory");
        return null;
    }

    public String editCategoryUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String oldName = request.getParameter("oldName");
        CategoryService categoryService = new CategoryServiceImpl();
        Category category = categoryService.findCategoryByName(oldName);
        request.setAttribute("category",category);
        return "/admin/category/edit.jsp";
    }
    public String editCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cname = request.getParameter("cname");
        String cid = request.getParameter("cid");
        CategoryService categoryService = new CategoryServiceImpl();
        Category category = categoryService.findCategoryById(cid);
        category.setCname(cname);
        categoryService.updateCategory(category);
        response.sendRedirect("/store_5/AdminCategoryServlet?method=findAllCategory");
        return null;
    }
    public String delCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cname = request.getParameter("cname");
        CategoryService categoryService = new CategoryServiceImpl();
        Category category = categoryService.findCategoryByName(cname);
        category.setLabel("0");
        categoryService.updateCategory(category);
        response.sendRedirect("/store_5/AdminCategoryServlet?method=findAllCategory");
        return null;
    }
}
