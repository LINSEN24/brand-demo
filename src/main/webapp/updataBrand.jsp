<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>updataBrand</title>
</head>
<body>
    <h3>修改品牌</h3>
    <form action="/brand-dome/updataBrandServlet" method="post">
        <input type="hidden" name="id" value="${brand.id}">
        品牌名称:<input type="text" name="brandName" value="${brand.brandName}"><br>
        企业名称:<input type="text" name="companyName" value="${brand.companyName}"><br>
        排序:<input type="text" name="ordered" value="${brand.ordered}"><br>
        描述信息:<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
        状态:
        <input type="radio" name="status" value="1" id="status_1">启用
        <input type="radio" name="status" value="0" id="status_0">禁用<br>
        <input type="submit" value="提交">
    </form>

<script>
    var status=${brand.status};
    if(status==1){
        document.getElementById("status_1").setAttribute("checked","checked")
    }else{
        document.getElementById("status_0").setAttribute("checked","checked")
    }
</script>

</body>
</html>
