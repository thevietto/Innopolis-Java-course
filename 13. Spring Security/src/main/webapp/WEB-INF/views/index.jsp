<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vietto
  Date: 28.11.16
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INDEX</title>
</head>
<body>

<security:authorize ifAnyGranted="ROLE_USER">
    <p>Это секретный текст для залогиненых</p>
</security:authorize>

<security:authorize ifNotGranted="ROLE_USER">
    <p>Ну ка залогиньтесь!</p>
</security:authorize>

</body>
</html>
