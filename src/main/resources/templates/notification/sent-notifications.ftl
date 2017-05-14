<#include "../main-template.ftl">

<#macro m_body>
<div class="blocks">
    <div class="block">
        <h2>Новое уведомление</h2>
        <form action="" method="post">
            <select name="groups">
                <#list groups as group>
                    <option value="${group.id}" label="${group.number}"/>
                </#list>
            </select>

            <div class="name"><label>Тема: <input type="text" name="theme"></label></div>
            <div class="text"><label>Текст: <textarea name="text"></textarea></label></div>
            <div><input type="submit" value="Отправить"></div>
        </form>
    </div>

    <#list notifications as notification>
        <div class="block">
            <div class="name">${notification.theme}</a></div>
            <div class="date">${notification.date?number_to_datetime}</div>
            <div class="text">${notification.text}</div>
        </div>
    </#list>
</div>
</#macro>

<@main title="Отправленные уведомления" username="${username}"/>