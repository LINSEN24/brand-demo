<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register</title>
</head>
<body>
<div>
    <form action="/brand-dome/registerServlet" method="post">
        <h1>欢迎注册</h1>
        <p>已有账号？<a href="login.jsp">登录</a></p>

        <p>
            Username:<input type="text" name="username" id="username"%><br>
            <span>${register_msg}</span>
        </p>
        <p>Password:<input type="password" name="password" id="password"></p>
        <p>
            验证码: <input type="text" name="vcode" id="vcode"><br>
            <img id="vcodeImg" src="/brand-dome/checkCodeServlet">
            <a href="#" id="changeImg">看不清?</a>
        </p>

        <div>
            <input type="submit" value="register">
            <input type="reset" value="reset">
        </div>
    </form>
</div>

<script>
    document.getElementById("vcodeImg").onclick=function(){
        document.getElementById("vcodeImg").src="/brand-dome/checkCodeServlet?"+new Date().getMilliseconds();
    }
    document.getElementById("changeImg").onclick=function(){
        document.getElementById("vcodeImg").src="/brand-dome/checkCodeServlet?"+new Date().getMilliseconds();
    }
</script>

</body>
</html>