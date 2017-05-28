<#include "../main-template.ftl">
<#macro m_body>
<div class="title">Полученные уведомления</div>

<div class="add"></div>

<div class="blocks">
    <#list user_notifications as user_notification>

        <div class="block">
            <div class="image">
                <a>
                    <#list user_notification.notification.user.roles as role >
                        <#assign userRole = "${role}">

                        <#if userRole == 'STAROSTA'>
                            С
                            <#break>
                        </#if>

                        <#if userRole == 'TEACHER'>
                            П
                            <#break>
                        </#if>

                        <#if userRole == 'WORKER'>
                            Д
                            <#break>
                        </#if>
                    </#list>
                </a>
            </div>
            <div class="name">${user_notification.notification.theme}</div>
            <div class="date">${user_notification.notification.date?number_to_datetime}
                от ${user_notification.notification.user.fullName}</div>
            <div class="text">${user_notification.notification.text}</div>
        </div>
    </#list>
</div>
</#macro>
<@main title="Уведомления" customClass=["notifications"]/>