<#include "main-template.ftl"/>
<#macro m_body>

<div class="col-md-4 col-md-offset-4 login-form">
    <h1>Войти</h1>
    <#if error??>
        <p>Вы что-то ввели не так!</p>
    </#if>
    <form action="/login/process" method="post">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" name="login" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" name="password" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-default">Войти</button>
        <a href="/registration" class="btn btn-default">Зарегистрироваться</a>
    </form>
</div>

</#macro>
<@main title="Логин"/>