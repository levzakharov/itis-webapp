<#include "../main-template.ftl">

<#macro m_body>
<div class="title"><a href="/documents">Документы</a> <i class="fa fa-chevron-right" aria-hidden="true"></i> <a
        href="/documents/teachers">Преподаватели</a>
    <div class="title">
        <@security.authorize access="hasAnyRole('TEACHER')">
            (<a href="/documents">Все</a> / <a href="/documents/teachers/${docuser.id}">Мои</a>)
        </@security.authorize>
        <@security.authorize access="hasAnyRole('ADMIN', 'WORKER')">
            (<a href="/documents">Все</a> / <a href="/documents/dean">Мои</a>)
        </@security.authorize>
    </div>
</div>
<div class="blocks">
    <#list users as user>
        <div class="block">
            <i class="fa fa-folder" aria-hidden="true"></i>
            <a href="/documents/teachers/${user.id}">${user.fullName}</a>
        </div>
    </#list>
</#macro>

<@main title="Документы" customScripts=["/js/news.js"] customClass=["docs"]  customStyles=["/css/docs.css"]/>