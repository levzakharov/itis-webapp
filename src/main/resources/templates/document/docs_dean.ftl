<#include "../main-template.ftl">

<#macro m_body>




<div class="title"><a href="/documents">Документы</a> <i class="fa fa-chevron-right" aria-hidden="true"></i> <a
        href="/documents/dean">Деканат</a>
</div>
<div class="title">
    <@security.authorize access="hasAnyRole('TEACHER')">
        (<a href="/documents">Все</a> / <a href="/documents/teachers/${docuser.id}">Мои</a>)
    </@security.authorize>
    <@security.authorize access="hasAnyRole('ADMIN', 'WORKER')">
        (<a href="/documents">Все</a> / <a href="/documents/dean">Мои</a>)
    </@security.authorize>
</div>
    <@security.authorize access="hasAnyRole('WORKER', 'ADMIN')">
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
            <@security.authorize access="hasAnyRole('WORKER', 'ADMIN')">
                <a href="#" onclick="document.forms['delete_${document.id}'].submit();"><i class="fa fa-times"
                                                                                           aria-hidden="true"></i></a>
                <form hidden action="/documents/${document.id}/delete" name="delete_${document.id}" method="post">
                </form>
            </@security.authorize>

        </div>
    </#list>
</div>

<#--<#list documents as document>-->
<#--<div style="display: table-cell; margin-bottom: auto" class="image"><a href="/files/${document.path}">-->
<#--<img style="width: 100px, height: auto;" src="/images/docicon.png"/>-->
<#--<p>${document.name}</p>-->
<#--</a>-->
<#--</div>-->
<#--</#list>-->
</#macro>

<@main title="Документы" customScripts=["/js/jquery-1.11.3.min.js",  "/js/news.js"] customClass=["docs"] customStyles=["/css/docs.css"]/>