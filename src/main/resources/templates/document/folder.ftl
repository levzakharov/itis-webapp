<#include "../main-template.ftl">

<#macro m_body>
<div class="blocks">
    <#list users as user>
        <a href="/documents/teachers/${user.id}">${user.fullName}</a>
    </#list>
</div>
</#macro>

<@main title="Документы" customScripts=["/js/jquery-1.11.3.min.js",  "/js/news.js"]/>