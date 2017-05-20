<#include "../main-template.ftl">

<#macro m_body>
<div class="blocks">
    <div class="block">
        <div class="name">${post.title}</div>
        <div class="date">${post.date?number_to_datetime}</div>
        <div class="text">${post.text}</div>
        <div class="image"></div>
    </div>
    <div class="block">
    <@security.authorize access="hasAnyRole('WORKER', 'ADMIN')">
        <h3>Редактировать новость</h3>
        <form action="/news/${post.id}" method="post">
            <input type="hidden" name="action" value="update">
            <div class="name"><label>Title: <input type="text" name="title" value="${post.title}" requiered></label></div>
            <div class="text"><label>Text: <textarea name="text" maxlength="1024" required>${post.text}</textarea></label></div>
            <div><input type="submit" value="Save"></div>
        </form>
        <h3>Удалить новость</h3>
        <form action="/news/${post.id}" method="post">
            <input type="hidden" name="action" value="delete">
            <div><input type="submit" value="Удались новость"></div>
        </form>
    </div>
    </@security.authorize>
</div>
</#macro>

<@main title="Новости" customScripts=["/js/jquery-1.11.3.min.js", "/js/news.js"]/>


