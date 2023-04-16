<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>add brand</title>
</head>
<body>
    <h3>添加品牌</h3>
    <form action="/brand-dome/addBrandServlet" method="post">
        品牌名称:<input type="text" name="brandName"><br>
        企业名称:<input type="text" name="companyName"><br>
        排序:<input type="text" name="ordered" ><br>
        描述信息:<textarea rows="5" cols="20" name="description"></textarea><br>
        状态:
        <input type="radio" name="status" value="1">启用
        <input type="radio" name="status" value="0">禁用<br>
        <input type="submit" value="提交">
    </form>



</body>
</html>