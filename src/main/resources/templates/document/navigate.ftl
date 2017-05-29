<#include "../main-template.ftl">

<#macro m_body>
<div class="title"><a href="/documents">Документы</a></div>
<div class="title">
    <@security.authorize access="hasAnyRole('TEACHER')">
        (<a href="/documents">Все</a> / <a href="/documents/teachers/${docuser.id}">Мои</a>)
    </@security.authorize>
    <@security.authorize access="hasAnyRole('ADMIN', 'WORKER')">
        (<a href="/documents">Все</a> / <a href="/documents/dean">Мои</a>)
    </@security.authorize>
</div>
<div class="blocks">
    <div class="block">
        <i class="fa fa-folder" aria-hidden="true"></i>
        <a href="/documents/dean">Деканат</a>
    </div>
    <div class="block">
        <i class="fa fa-folder" aria-hidden="true"></i>
        <a href="/documents/teachers">Преподаватели</a>
    </div>
</div>
</#macro>

<@main title="Документы" customScripts=["/js/news.js"] customClass=["docs"] customStyles=["/css/docs.css"]/>