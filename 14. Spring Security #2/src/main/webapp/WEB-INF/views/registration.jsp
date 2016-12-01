<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: viettoГ
  Date: 01.12.16
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form:form action="/registration" method="post" modelAttribute="userForm">
    <table>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Имя</form:label></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="surname">Фамилия</form:label></td>
            <td><form:input path="surname"/></td>
            <td><form:errors path="surname"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Пароль</form:label></td>
            <td><form:password path="password"/></td>
            <td><form:errors path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="repassword">Пароль ещё раз</form:label></td>
            <td><form:password path="repassword"/></td>
            <td><form:errors path="repassword"/></td>
        </tr>
    </table>
    <input type="submit" value="Зарегистрируйте меня!"/>
</form:form>

</body>
</html>
