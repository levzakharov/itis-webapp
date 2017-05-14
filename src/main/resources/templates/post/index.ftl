<#include "../main-template.ftl">

<#macro m_body>
<div class="blocks">
    <div class="block">
        <h2>Добавить новость</h2>
        <form action="/posts/new" method="post">
            <div class="name"><label>Title: <input type="text" name="title"></label></div>
            <div class="text"><label>Text: <textarea name="text"></textarea></label></div>
            <div><input type="submit" value="Save"></div>
        </form>
    </div>
    <#list posts as post>
        <div class="block">
            <div class="name"><a href="/posts/${post.id}">${post.title}</a></div>
            <div class="date">${post.date?number_to_datetime}</div>
            <div class="text">${post.text}</div>
            <div class="image"></div>
        </div>
    </#list>
</div>
</#macro>

<@main title="Новости" username="Имя пользователя"/>
