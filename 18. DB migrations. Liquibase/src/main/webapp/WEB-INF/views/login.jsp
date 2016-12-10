<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vietto
  Date: 28.11.16
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Логин</title>
</head>
<body>
<h1>Наша форма</h1>
<c:if test="${error != null}">
    <p>Вы что-то ввели не так!</p>
</c:if>
<form action="/login/process" method="post">
    Логин: <input type="text" name="login"> <br>
    Пароль <input type="password" name="password"> <br>
    Запомнить? <input type="checkbox" name="remember"> <br>
    <input type="submit">
</form>

<p><a href="/registration">Зарегистрироваться</a></p>
</body>
</html>
