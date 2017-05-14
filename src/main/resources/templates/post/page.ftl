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
        <h3>Редактировать новость</h3>
        <form action="/posts/${post.id}" method="post">
            <input type="hidden" name="action" value="update">
            <div class="name"><label>Title: <input type="text" name="title" value="${post.title}"></label></div>
            <div class="text"><label>Text: <textarea name="text">${post.text}</textarea></label></div>
            <div><input type="submit" value="Save"></div>
        </form>
        <h3>Удалить новость</h3>
        <form action="/posts/${post.id}" method="post">
            <input type="hidden" name="action" value="delete">
            <div><input type="submit" value="Удались новость"></div>
        </form>
    </div>
</div>
</#macro>

<@main title="Новости" username="Имя пользователя"/>


