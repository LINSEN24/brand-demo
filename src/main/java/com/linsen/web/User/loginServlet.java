package com.linsen.web.User;

import com.linsen.pojo.User;
import com.linsen.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private UserService userService=new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user=userService.login(username,password);

        if (user==null){
            //失败
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            //成功
            if("1".equals(remember)){
                Cookie c_username = new Cookie("username", URLEncoder.encode(username,"UTF-8"));
                Cookie c_password = new Cookie("password", password);
                c_username.setMaxAge(7*24*60*60);
                c_password.setMaxAge(7*24*60*60);
                response.addCookie(c_password);
                response.addCookie(c_username);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/selectAllBrandServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
