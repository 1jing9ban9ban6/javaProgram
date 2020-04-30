package com.jing.stroe.web.servlet;

import com.jing.stroe.domain.Cart;
import com.jing.stroe.domain.CartItem;
import com.jing.stroe.domain.Product;
import com.jing.stroe.domain.User;
import com.jing.stroe.service.ProductService;
import com.jing.stroe.service.ServiceImpl.ProductServiceImpl;
import com.jing.stroe.service.ServiceImpl.UserServiceImpl;
import com.jing.stroe.service.UserService;
import com.jing.stroe.web.base.BaseServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CartServlet")
public class CartServlet extends BaseServlet {
    public String addCartItemToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 从session里面获取数据
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        if (cart == null){
            // 判断session 里是否已经有了购物车 如果没有 就创建一个购物车加到session里面
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        // 获取request 里面的参数
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String pid = request.getParameter("pid");
        // 根据传过来的pid 获取到商品对象方便添加到cartItem
        ProductService productService = new ProductServiceImpl();
        Product productById = productService.getProductById(pid);
        // 创建CartItem实体并将传过来的 参数 放进去
        CartItem cartItem = new CartItem();
        cartItem.setNum(quantity);
        cartItem.setProduct(productById);
        // 将购物项添加到购物车
        cart.addCartItemToCart(cartItem);
        // 重定向
        response.sendRedirect("/store_5/jsp/cart.jsp");
        return null;
    }
    public String removeCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 从session里面获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        // 获取请求过来的pid参数
        String id = request.getParameter("id");
        cart.removeCartItem(id);
        // 重定向
        response.sendRedirect("/store_5/jsp/cart.jsp");
        return null;
    }

    public String clearCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 从session里面获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        // 清空购物车
        cart.clearCart();
        // 重定向
        response.sendRedirect("/store_5/jsp/cart.jsp");
        return null;
    }
}
