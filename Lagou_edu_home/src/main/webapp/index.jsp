<%--
  Created by IntelliJ IDEA.
  User: Luobogan
  Date: 2021/4/24
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/test?methodName=addCourse">新建课程</a>
    <a href="${pageContext.request.contextPath}/test?methodName=findByName">根据课程名搜索</a>
    <a href="${pageContext.request.contextPath}/test?methodName=findByStatus">根据状态搜索</a>

</body>
</html>
