package com.jing.stroe.web.servlet;

import com.jing.stroe.domain.*;
import com.jing.stroe.service.OrderService;
import com.jing.stroe.service.ProductService;
import com.jing.stroe.service.ServiceImpl.OrderServiceImpl;
import com.jing.stroe.service.ServiceImpl.ProductServiceImpl;
import com.jing.stroe.utils.PaymentUtil;
import com.jing.stroe.utils.UUIDUtils;
import com.jing.stroe.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends BaseServlet {

    public String saveOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 从session当中拿到用户数据
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            request.setAttribute("msg", "请登录后在下单");
            // 如果session中没有数据 叫用户先去登录
            return "jsp/info.jsp";
        }
        // 获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        // 创建订单对象为订单赋值
        Order order = new Order();
        order.setOid(UUIDUtils.getCode());
        order.setOrdertime(new Date());
        order.setTotal(cart.getTotal());
        order.setState(1);
        order.setUser(loginUser);
        // 遍历购物项的同时，获取订单项给订单项赋值
        for (CartItem cartItem : cart.getCartItem()) {
            // 创建订单项
            OrderItem orderItem = new OrderItem();
            orderItem.setItemid(UUIDUtils.getCode());
            orderItem.setQuantity(cartItem.getNum());
            orderItem.setTotal(cartItem.getSubTotal());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setOrder(order);
            // 向订单中添加订单项
            order.getList().add(orderItem);
        }
        // 调用业务层 保存订单数据
        OrderService orderService = new OrderServiceImpl();
        orderService.saveOrder(order);
        // 清空购物车
        cart.clearCart();
        request.setAttribute("order", order);
        return "/jsp/order_info.jsp";
    }

    public String findMyOrdersWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取用户的session
        User user = (User) request.getSession().getAttribute("loginUser");
        // 获取当前页
        int num = Integer.parseInt(request.getParameter("num"));
        // 实现service 1. 获取了分页的相关信息 2.
        OrderService orderService = new OrderServiceImpl();
        PageModel pm = orderService.findMyOrdersWithPage(user, num);
        // 返回request
        request.setAttribute("page", pm);
        return "/jsp/order_list.jsp";
    }
    public String findOrderById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取传过来的参数id
        String oid = request.getParameter("oid");
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.findOrderById(oid);
        // 返回request
        request.setAttribute("order", order);
        return "/jsp/order_info.jsp";
    }
    public String payOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取传过来的参数id
        String oid = request.getParameter("oid");
        String address = request.getParameter("address");
        String name = request.getParameter("name");
        String telephone = request.getParameter("telephone");
        String pd_FrpId = request.getParameter("pd_FrpId");
        // 向服务器发一条更新语句 更新订单的参数(电话 姓名 地址)
        OrderService orderService = new OrderServiceImpl();
        Order orderById = orderService.findOrderById(oid);
        orderById.setAddress(address);
        orderById.setName(name);
        orderById.setTelephone(telephone);
        orderService.updateOrder(orderById);

        // 把付款所需要的参数准备好:
        String p0_Cmd = "Buy";
        //商户编号
        String p1_MerId = "10001126856";
        //订单编号
        String p2_Order = oid;
        //金额
        String p3_Amt = "0.01";
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        //接受响应参数的Servlet
        String p8_Url = "http://localhost:8080/store_5/OrderServlet?method=callBack";
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        //公司的秘钥 md5
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

//        调用易宝的加密算法,对所有数据进行加密,返回电子签名
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_Pid=").append(p5_Pid).append("&");
        sb.append("p6_Pcat=").append(p6_Pcat).append("&");
        sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId=").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac);

        System.out.println(sb.toString());
        // 使用重定向：
        response.sendRedirect(sb.toString());

        //response.sendRedirect("https://www.yeepay.com/app-merchant-proxy/node?p0_cmd=Buy&p1_MerId=111111&k1=v1&k2=v2");
        //服务端重新定向到易宝支付,同时向易宝支付传递了数据
        return null;
    }
    public String callBack(HttpServletRequest request, HttpServletResponse response) throws Exception {

        OrderService orderService = new OrderServiceImpl();
        String p1_MerId = request.getParameter("p1_MerId");
        String r0_Cmd = request.getParameter("r0_Cmd");
        String r1_Code = request.getParameter("r1_Code");
        String r2_TrxId = request.getParameter("r2_TrxId");
        String r3_Amt = request.getParameter("r3_Amt");
        String r4_Cur = request.getParameter("r4_Cur");
        String r5_Pid = request.getParameter("r5_Pid");
        String r6_Order = request.getParameter("r6_Order");
        String r7_Uid = request.getParameter("r7_Uid");
        String r8_MP = request.getParameter("r8_MP");
        String r9_BType = request.getParameter("r9_BType");
        String rb_BankId = request.getParameter("rb_BankId");
        String ro_BankOrderId = request.getParameter("ro_BankOrderId");
        String rp_PayDate = request.getParameter("rp_PayDate");
        String rq_CardNo = request.getParameter("rq_CardNo");
        String ru_Trxtime = request.getParameter("ru_Trxtime");

        // hmac
        String hmac = request.getParameter("hmac");
        // 利用本地密钥和加密算法 加密数据
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
        boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
                r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
                r8_MP, r9_BType, keyValue);
        if (isValid) {
            // 有效
            if (r9_BType.equals("1")) {
                // 浏览器重定向
                //response.setContentType("text/html;charset=utf-8");
                //response.getWriter().println(	"支付成功！订单号：" + r6_Order + "金额：" + r3_Amt);
                Order order=orderService.findOrderById(r6_Order);
                //跟新订单状态
                order.setState(2);
                orderService.updateOrder(order);
                request.setAttribute("msg", "支付成功！订单号：" + r6_Order + "金额：" + r3_Amt);
                return "/jsp/info.jsp";

            } else if (r9_BType.equals("2")) {
                // 修改订单状态:
                // 服务器点对点，来自于易宝的通知
                System.out.println("收到易宝通知，修改订单状态！");//
                // 回复给易宝success，如果不回复，易宝会一直通知
                response.getWriter().print("success");
            }

        } else {
            throw new RuntimeException("数据被篡改！");
        }

        return null;
    }
}
