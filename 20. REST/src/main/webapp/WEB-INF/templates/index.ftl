<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<!DOCTYPE html>
<html>
<head>
    <title>INDEX</title>

    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
</head>
<body>

<@security.authorize ifAnyGranted="ROLE_USER">
    <@security.authentication property"principal.username" var="username"/>
</@security.authorize>

<header>
    <div>
        <#if username??>
            <p>Привет, ${username}! <a href="/logout">Выйти</a> </p>
            <#else>
            <p><a href="/login">Войти</a> или <a href="/registration">Зарегистрироваться</a></p>
        </#if>
    </div>
</header>

<h1>Здрасти</h1>

</body>
</html>