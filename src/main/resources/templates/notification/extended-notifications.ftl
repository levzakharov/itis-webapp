<#include "../main-template.ftl">
<#macro m_body>
<div class="title">Уведомления</div>
<div class="add">
    <div class="button">Добавить уведомление</div>
    <div class="cancel">Отменить</div>
    <div class="block">
        <div class="title">Создание уведомления</div>

        <@form.form commandName="notification_creation_form" action="/notifications/add" method="post">
            <@security.authorize access="hasAnyRole('WORKER', 'ADMIN','TEACHER')">
                <div class="name">
                    <div class="sub">Кому</div>
                    <@form.select name="groups" multiple="multiple" required="required">
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
                    </@form.select>
                </div>
            </@security.authorize>

            <div class="text">
                <label> Тема <@form.input path="theme" type="text" required="required" maxlength="255"/>
            </div>
            <div class="text">
                <@form.errors path="theme" cssStyle="color: #ab2020;"/>
            </div>
            <br>
            <div class="text">
                <@form.textarea path="text" required="required" placeholder="Текст"/>
            </div>
        <div class="text">
            <@form.errors path="text" cssStyle="color: #ab2020;"/>
        </div>
            <img>
            <input type="submit" value="Создать">
        </@form.form>
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

<@main title="Уведомления" customScripts=["/js/multiple-select.js", "/js/notifications.js"] customStyles=["/css/multiple-select.css"] customClass=["notifications"]/>
