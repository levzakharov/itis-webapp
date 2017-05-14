<#include "../main-template.ftl">
<#macro m_body>
<div class="title">Полученные уведомления</div>

<div class="add"></div>

<div class="blocks">
    <#list user_notifications as user_notification>
        <div class="block">
            <div class="name">${user_notification.notification.theme}</div>
            <div class="date">${user_notification.notification.date?number_to_datetime}</div>
            <div class="text">${user_notification.notification.text}</div>
        </div>
    </#list>
</div>
</#macro>
<@main title="Уведомления" username="Имя пользователя" customClass=["notifications"]/>