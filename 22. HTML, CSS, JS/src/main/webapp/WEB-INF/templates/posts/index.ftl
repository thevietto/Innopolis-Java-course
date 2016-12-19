<#include "../main-template.ftl"/>
<#macro m_body>

<div class="col-md-8 col-md-offset-2 posts">

    <img src="/resources/img/vzuh.jpg">

    <h1>Добро пожаловать в мой блог, <@security.authentication property="principal.name"/></h1>

    <form action="/posts" method="get">
        <input type="text" name="phrase" width="600px">
        <input type="submit" value="Search" class="btn btn-default">
    </form>

    <a href="/posts/add" class="btn btn-default">Добавить новый пост</a>

    <#list posts as post>
        <div class="post">
            <h3>${post.title}</h3>
            <small>${post.date}</small>
            <small>Автор: ${(post.user.fullName)!"Неизвестен"}</small>
            <p class="post-text">${post.text[0..*127]}</p>
            <p style="display: none;" class="post-text">${post.text}</p>
            <a href="/posts/${post.id}" class="show-post-text">Читать полностью...</a><br>
            <@security.authentication property="principal.id" var="user_id"/>
            <@security.authorize access="${(post.user?? && user_id == post.user.id)?c}">
                <a href="/posts/${post.id}/delete" class="btn btn-danger delete-post">Удалить</a>
                <a href="/posts/${post.id}/edit" class="btn btn-default">Редактировать</a>
            </@security.authorize>
        </div>
    <#else>
        <p>Пока ничего нету</p>
    </#list>

</div>

</#macro>
<@main title="Посты" customScripts=["/resources/js/posts.js"]/>