<#include "../main-template.ftl">

<#macro m_body>
<div class="title"><a href="/documents">Документы</a></div>
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

<@main title="Документы" customScripts=["/js/jquery-1.11.3.min.js",  "/js/news.js"] customClass=["docs"] customStyles=["/css/docs.css"]/>