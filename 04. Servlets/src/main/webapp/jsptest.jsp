<%--
  Created by IntelliJ IDEA.
  User: vietto
  Date: 07.11.16
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP TEST</title>
</head>
<body>

<%-- COMMENT --%>

<%! String message1 = "Hey"; %>

<h1>Hello!</h1>
<p>Your message is: ${mes}</p>


<%
    System.out.println("hello from jsp");
%>

</body>
</html>
