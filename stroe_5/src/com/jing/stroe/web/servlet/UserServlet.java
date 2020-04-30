package com.jing.stroe.web.servlet;

import com.jing.stroe.domain.User;
import com.jing.stroe.service.ServiceImpl.UserServiceImpl;
import com.jing.stroe.service.UserService;
import com.jing.stroe.utils.MailUtils;
import com.jing.stroe.utils.MyBeanUtils;
import com.jing.stroe.utils.UUIDUtils;
import com.jing.stroe.web.base.BaseServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@WebServlet(name = "UserServlet")
public class UserServlet extends BaseServlet {
    /**
     * 注册跳转界面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String registerUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/register.jsp";
    }

    /**
     * 登录跳转界面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String loginUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/login.jsp";
    }

    /**
     * 用户注册  没有用户是否已经存在
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String userRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取表单参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();

        // 利用工具类 填充数据到对象
        MyBeanUtils.populate(user, parameterMap);

        // 为用户的其他属性赋值
        user.setUid(UUIDUtils.getId());
        user.setState(0);
        user.setCode(UUIDUtils.getCode());

        // 调用业务层功能
        UserService userService = new UserServiceImpl();
        try {
            userService.userRegist(user);
            MailUtils.sendMail(user.getEmail(), user.getCode());
            // 注册成功的消息
            request.setAttribute("msg", "用户注册成功，请激活!");
        }catch (Exception e){
            // 注册失败的消息
            request.setAttribute("msg", "用户注册失败，请重新注册!");
        }

        // 跳转页面
        return "/jsp/info.jsp";
    }

    /**
     * 用户激活
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取链接里面的激活参数
        String code = request.getParameter("code");

        // 调用业务层的查找账户，根据code查看数据库中是否有对应数据
        UserService userService = new UserServiceImpl();
        User user = userService.userActive(code);
        if (user != null){
            user.setCode("");
            user.setState(1);
            userService.userUpdate(user);
            request.setAttribute("msg", "用户激活成功,请登录");
            return "/jsp/login.jsp";
        }
        request.setAttribute("msg", "用户激活失败，请重新注册");
        return "/jsp/info.jsp";
    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 将页面的数据构造到对象里面
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        MyBeanUtils.populate(user, parameterMap);
        // 调用业务层方法
        UserService userService = new UserServiceImpl();
        User user01 = null;
        try {
            user01 = userService.userLogin(user);
            // 用户登录成功将用户信息放入session中
            request.getSession().setAttribute("loginUser", user01);
            response.sendRedirect("/store_5/index.jsp");
            return null;
        } catch (Exception e){
            String message = e.getMessage();
            request.setAttribute("msg", message);
            return "/jsp/login.jsp";
        }
    }

    /**
     * 用户退出
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 清空session
        request.getSession().invalidate();
        // 重定向到首页
        response.sendRedirect("/store_5/index.jsp");
        return null;
    }
}
