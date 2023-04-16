package com.linsen.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest)request;

        String[] urls={"/login.jsp","/register.jsp","/index.html","/checkCodeServlet","/loginServlet","/registerServlet"};
        String url=req.getRequestURL().toString();
        for (String u:urls){
            if(url.contains(u)){
                chain.doFilter(request, response);
                return;
            }
        }

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user!=null){
            //登录过
            chain.doFilter(request, response);
        }else{
            //没有登录
            req.setAttribute("login_msg","你还没有登录!");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }
    }
}
