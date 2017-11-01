<%--
  Created by IntelliJ IDEA.
  User: wj
  Date: 2017/11/1
  Time: 下午4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>学生表</title>
</head>
<body>

<table>
<c:forEach items="${list}" var="student">
    <tr>
        <td>${student.name}</td>
        <td>${student.age}</td>
    </tr>
</c:forEach>
</table>

</body>
</html>
