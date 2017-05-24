<#include "../main-template.ftl">

<#macro m_body>
<div class="blocks">
    <@security.authorize access="hasAnyRole('WORKER', 'ADMIN', 'TEACHER')">
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


    <#list documents as document>
        <div style="display: table-cell; margin-bottom: auto" class="image"><a href="/files/${document.path}">
            <img style="width: 100px, height: auto;" src="/images/docicon.png"/>
            <p>${document.name}</p>
        </a>
        </div>
    </#list>
</div>
</#macro>

<@main title="Документы" customScripts=["/js/jquery-1.11.3.min.js",  "/js/news.js"]/>