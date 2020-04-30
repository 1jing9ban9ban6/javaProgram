package com.jing.stroe.web.filter;

import com.jing.stroe.domain.User;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter(filterName = "PrivilegeFilter")
public class PrivilegeFilter implements Filter {

	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		User uu=(User)req.getSession().getAttribute("loginUser");
		if(null==uu){
			req.setAttribute("msg", "请登录后在访问");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	

}
