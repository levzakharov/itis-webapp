<#include "../main-template.ftl">

<#macro m_body>
<div class="blocks">
    <div class="add">
        <div class="button">Добавить новость</div>
        <div class="cancel">Отменить</div>
        <div class="block">
            <div class="title">Создание новости</div>
            <form action="/news/new" method="post" enctype="multipart/form-data">
                <div class="name">
                    <input type="text" name="title" placeholder="Название" required>
                </div>
                <div class="text">
                    <textarea placeholder="Текст" name="text" required maxlength="1024"></textarea>
                </div>
                <input type="file" multiple name="images">
                <input type="submit" value="Применить">
            </form>
        </div>
    </div>

    <#list posts as post>
        <div class="block">
                <div class="edit">
                    <div class="title">Редактирование новости</div>
                    <form action="/news/update/${post.id}" method="post">
                        <input type="hidden" name="action" value="update">
                        <div class="name">
                            <input type="text" placeholder="Название" name="title" value="${post.title}">
                        </div>
                        <div class="text">
                            <textarea name="text" placeholder="Текст">${post.text}</textarea>
                        </div>
                        <input type="submit" value="Применить">
                        <div class="cancel">Отменить</div>
                    </form>
                </div>
                <div class="buttons">
                    <div class="button">Редактировать</div>
                    <form action="/news/delete/${post.id}" name="delete_${post.id}" method="post">
                        <input type="hidden" name="action" value="delete">
                        <div class="button" onclick="document.forms['delete_${post.id}'].submit();">Удалить</div>
                    </form>
                </div>
            <div class="name">${post.title}</div>
            <div class="date">${post.date?number_to_datetime}</div>
            <div class="text">${post.text}</div>
            <#if post.images?size != 0 >
                <#list post.images as image>
                    <div class="image">
                        <img src="/files/${image.title}">
                    </div>
                </#list>
            </#if>
        </div>
    </#list>
</div>
</#macro>

<@main title="Новости" customScripts=["/js/jquery-1.11.3.min.js",  "/js/news.js"]/>
