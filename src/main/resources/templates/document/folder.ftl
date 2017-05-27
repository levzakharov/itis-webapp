<#include "../main-template.ftl">

<#macro m_body>
<div class="title"><a href="/documents">Документы</a> <i class="fa fa-chevron-right" aria-hidden="true"></i> <a href="/documents/teachers">Преподаватели</a>
</div>
<div class="blocks">
<#list users as user>
    <div class="block">
        <i class="fa fa-folder" aria-hidden="true"></i>
        <a href="/documents/teachers/${user.id}">${user.fullName}</a>
    </div>
</#list>
</#macro>

<@main title="Документы" customScripts=["/js/jquery-1.11.3.min.js",  "/js/news.js"] customClass=["docs"]  customStyles=["/css/docs.css"]/>