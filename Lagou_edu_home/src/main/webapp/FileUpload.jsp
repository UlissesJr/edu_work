<%--
  Created by IntelliJ IDEA.
  User: Luobogan
  Date: 2021/5/30
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- 文件上传的三要素：
            1. 表单提交的方式 必须是 POST
            2. 表单的enctype属性必须为：multipart/form-data
            3. 表单中必须有文件上传项
     --%>
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload">
        <input type="file" name="upload">
        <br>
        <input type="text" name="name">
        <input type="text" name="password">
        <input type="submit" value="文件上传">
    </form>

    <img src="/upload/52e152db295949ad8d02b5b0bb236641_A.png">

</body>
</html>
