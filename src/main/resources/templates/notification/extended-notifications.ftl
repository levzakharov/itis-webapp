<#include "../main-template.ftl">
<#macro m_body>
<div class="title">Уведомления</div>
<div class="add">
    <div class="button">Добавить уведомление</div>
    <div class="cancel">Отменить</div>
    <div class="block">
        <div class="title">Создание уведомления</div>
        <form name="notification" action="/notifications/add" method="post">
            <#if isStarosta>
            <#else>
                <div class="name">
                    <div class="sub">Кому</div>
                    <select name="groups" multiple="multiple">
                        <optgroup label="1 курс">
                            <#list groups_1 as group>
                                <option value="${group.id}">${group.number}</option>
                            </#list>
                        </optgroup>
                        <optgroup label="2 курс">
                            <#list groups_2 as group>
                                <option value="${group.id}">${group.number}</option>
                            </#list>
                        </optgroup>
                        <optgroup label="3 курс">
                            <#list groups_3 as group>
                                <option value="${group.id}">${group.number}</option>
                            </#list>
                        </optgroup>
                        <optgroup label="4 курс">
                            <#list groups_4 as group>
                                <option value="${group.id}">${group.number}</option>
                            </#list>
                        </optgroup>
                        <optgroup label="магистры 1 курс">
                            <#list groups_5 as group>
                                <option value="${group.id}">${group.number}</option>
                            </#list>
                        </optgroup>
                        <optgroup label="магистры 2 курс">
                            <#list groups_6 as group>
                                <option value="${group.id}">${group.number}</option>
                            </#list>
                        </optgroup>
                    </select>
                </div>
            </#if>

            <div class="text">
                <label> Тема <input name="theme" type="text"/> </label>
            </div>
            <br>
            <div class="text">
                <textarea name="text" placeholder="Текст"></textarea>
            </div>
            <img>
            <input type="submit" value="Создать">
        </form>
    </div>
</div>

<div class="filter">
    <div class="modes">
        <div class="button">Отправленные</div>
        <div class="button active">Полученные</div>
    </div>
</div>
<div class="blocks received">
    <#list received_notifications as user_notification>
        <div class="block">
            <div class="name">${user_notification.notification.theme}</div>
            <div class="date">${user_notification.notification.date?number_to_datetime}</div>
            <div class="text">${user_notification.notification.text}</div>
        </div>
    </#list>
</div>

<div class="blocks sent">
    <#list sent_notifications as notification>
        <div class="block">
            <div class="name">${notification.theme}</div>
            <div class="date">${notification.date?number_to_datetime}</div>
            <div class="text">${notification.text}</div>
        </div>
    </#list>
</div>

</#macro>

<@main title="Уведомления" customScripts=["/js/jquery-1.11.3.min.js", "/js/multiple-select.js", "/js/notifications.js"] customStyles=["/css/multiple-select.css"] customClass=["notifications"]/>