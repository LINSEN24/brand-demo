<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login In</title>
</head>
<body>
    <div>
        <form action="/brand-dome/loginServlet" method="post">
            <h1>Login In</h1>
            <div id="errorMsg">${login_msg} ${register_msg}</div>
            <%!
                String username;
            %>
            <%
                Cookie[] cookies = request.getCookies();
                if(cookies!=null){
                    for(Cookie cookie:cookies){
                        if (cookie.getName().equals("username")){
                            username= URLDecoder.decode(cookie.getValue(),"UTF-8");
                        }
                    }
                }
            %>
            <p>Username:<input type="text" name="username" id="username" value=<%= username==null?"":username %>></p>
            <p>Password:<input type="password" name="password" id="password" value="${cookie.password.value}"></p>
            <p>Remember:<input type="checkbox" name="remember" id="remember" value="1"></p>

            <div>
                <input type="submit" value="login">
                <input type="reset" value="reset">
                <a href="register.jsp">没有账号?</a>
            </div>

        </form>
    </div>

</body>
</html>
