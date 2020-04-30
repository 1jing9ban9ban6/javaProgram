package com.jing.stroe.web.servlet;

import com.jing.stroe.domain.Order;
import com.jing.stroe.service.OrderService;
import com.jing.stroe.service.ServiceImpl.OrderServiceImpl;
import com.jing.stroe.web.base.BaseServlet;
import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@WebServlet(name = "AdminOrderServlet")
public class AdminOrderServlet extends BaseServlet {
    public String findAllOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        OrderService orderService = new OrderServiceImpl();
        List<Order> allOrder = orderService.findAllOrder();
        request.setAttribute("list",allOrder);
        return "/admin/order/list.jsp";
    }
    public String findOrderByOidWithAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        OrderService orderService = new OrderServiceImpl();
        Order orderById = orderService.findOrderById(id);
        String json = JSONArray.fromObject(orderById.getList()).toString();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
        return null;
    }
    public String updateOrderById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("oid");
        OrderService orderService = new OrderServiceImpl();
        Order orderById = orderService.findOrderById(id);
        orderById.setState(3);
        orderService.updateOrder(orderById);
        response.sendRedirect("/store_5/AdminOrderServlet?method=findAllOrder");
        return null;
    }
}
