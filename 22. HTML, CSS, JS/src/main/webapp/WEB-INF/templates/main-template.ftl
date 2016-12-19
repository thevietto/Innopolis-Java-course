<#macro main title="Main page" customStyles=[] customScripts=[]>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">

    <script src="/resources/js/jquery-3.1.1.min.js"></script>

    <#list customStyles as style>
        <link rel="stylesheet" type="text/css" href="${style}">
    </#list>
    <#list customScripts as script>
        <script src="${script}"></script>
    </#list>
</head>
<body>
    <#include "header.ftl"/>

<div class="content">
    <@m_body/>
</div>


</body>
</html>
</#macro>
