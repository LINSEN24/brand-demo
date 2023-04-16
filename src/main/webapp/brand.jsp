<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>brand</title>
</head>
<body>

    <h1>${user.username},欢迎您。</h1>
    
    <table border="1" cellpadding="0" cellspacing="0" width="80%">
        <tr align="center">
            <th>id</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>描述信息</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${brands}" var="brand">
            <tr align="center">
                <td>${brand.id}</td>
                <td>${brand.brandName}</td>
                <td>${brand.companyName}</td>
                <td>${brand.ordered}</td>
                <td>${brand.description}</td>
                <td>${brand.status==1?"启用":"禁用"}</td>
                <td>
                    <a href="/brand-dome/selectByIdBrandServlet?id=${brand.id}">修改</a>
                    <a href="/brand-dome/deleteBrandServlet?id=${brand.id}" onclick="javascript:return del()">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" value="新增" id="add"><br>

    <script>
        document.getElementById("add").onclick=function(){
            location.href="/brand-dome/addBrand.jsp"
        }
        function del() {
            var tag=confirm("确认删除？");
            return tag;
        }
    </script>

</body>
</html>
