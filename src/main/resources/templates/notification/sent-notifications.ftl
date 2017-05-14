<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Уведомления</div>
<div class="add">
    <div class="button">Добавить уведомление</div>
    <div class="cancel">Отменить</div>
    <div class="block">
        <div class="title">Создание уведомления</div>
        <form name="notification" action="/notifications/add" method="post">
            <div class="name">
                <div class="sub">Кому</div>
                <select name="groups" multiple="multiple">
                    <optgroup label="1 курс">
                        <#list groups_1 as group_1>
                            <option value="${group_1.id}">${group_1.number}</option>
                        </#list>
                    </optgroup>
                    <optgroup label="2 курс">
                        <#list groups_2 as group_2>
                            <option value="${group_2.id}">${group_2.number}</option>
                        </#list>
                    </optgroup>
                    <optgroup label="3 курс">
                        <#list groups_3 as group_3>
                            <option value="${group_3.id}">${group_3.number}</option>
                        </#list>
                    </optgroup>
                    <optgroup label="4 курс">
                        <#list groups_4 as group_4>
                            <option value="${group_4.id}">${group_4.number}</option>
                        </#list>
                    </optgroup>
                </select>
            </div>
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
<div class="blocks">
    <#list notifications as notification>
        <div class="block">
            <div class="name">${notification.theme}</div>
            <div class="date">${notification.date?number_to_datetime}</div>
            <div class="text">${notification.text}</div>
        </div>
    </#list>
</div>
</#macro>

<@main title="Уведомления" username="Имя пользователя" customScripts=["/js/jquery-1.11.3.min.js", "/js/multiple-select.js", "/js/notifications.js"] customStyles=["/css/multiple-select.css"]/>