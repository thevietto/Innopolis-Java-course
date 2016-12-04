<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vietto
  Date: 12.11.16
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Бложек</title>
</head>
<body>
<h1>Добро пожаловать в мой блог, <security:authentication property="principal.name"/></h1>

<form action="/posts" method="get">
    <input type="text" name="phrase" width="600px">
    <input type="submit" value="Search">
</form>

<a href="/posts/add">Добавить новый пост</a>

<c:if test="${posts.size() == 0}">
    <p>Пока ничего нету</p>
</c:if>

<c:forEach var="post" items="${posts}">
    <h3>${post.title}</h3>
    <small>${post.date}</small>
    <small>Автор: ${post.user.fullName}</small>
    <p>${post.text.substring(0, post.text.length() > 127 ? 127 : post.text.length())}</p>
    <a href="/posts/${post.id}">Читать полностью...</a><br>
    <security:authentication property="principal.id" var="user_id"/>
    <security:authorize access="${user_id eq post.user.id}">
        <a href="/posts/${post.id}/delete">Удалить</a>
        <a href="/posts/${post.id}/edit">Редактировать</a>
    </security:authorize>

    <hr>
</c:forEach>

</body>
</html>
