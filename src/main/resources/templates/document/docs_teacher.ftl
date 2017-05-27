<#include "../main-template.ftl">

<#macro m_body>


<div class="title"><a href="/documents">Документы</a> <i class="fa fa-chevron-right" aria-hidden="true"></i> <a
        href="/documents/teachers">Преподаватели</a>
    <i class="fa fa-chevron-right" aria-hidden="true"></i> <a
            href="/documents/teachers/>${documents[0].user.id}">${documents[0].user.fullName}</a>
</div>
    <@security.authorize access="hasAnyRole('TEACHER')">
        <#if isOwner>
        <div class="add">
            <div class="button">Добавить документ</div>
            <div class="cancel">Отменить</div>
            <div class="block">
                <div class="title">Загрузка документа</div>
                <form action="/documents/new" method="post" enctype="multipart/form-data">
                    <div class="name">
                        <label> Документы
                            <input type="file" multiple name="documents"></label>
                    </div>
                    <input type="submit" value="Загрузить">
                </form>
            </div>
        </div>
        </#if>
    </@security.authorize>
<div class="blocks">
    <#list documents as document>

        <div class="block"><a href="/files/${document.path}">
            <#if document.name?ends_with("doc") || document.name?ends_with("docx")>
                <i class="fa fa-file-word-o" aria-hidden="true"></i>
            <#elseif document.name?ends_with("xls") || document.name?ends_with("xlsx")>
                <i class="fa fa-file-excel-o" aria-hidden="true"></i>
            <#elseif document.name?ends_with("pdf")>
                <i class="fa fa-file-pdf-o" aria-hidden="true"></i>
            <#else>
                <i class="fa fa-file" aria-hidden="true"></i>
            </#if>
        ${document.name}</a>
        </div>
    </#list>
</div>
</#macro>

<@main title="Документы" customScripts=["/js/jquery-1.11.3.min.js",  "/js/news.js"] customClass=["docs"] customStyles=["/css/docs.css"]/>